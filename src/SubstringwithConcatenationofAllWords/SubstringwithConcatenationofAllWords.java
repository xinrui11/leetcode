package SubstringwithConcatenationofAllWords;

import java.util.*;

/**
 You are given a string, s, and a list of words, words, that are all of the same length.
 Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class SubstringwithConcatenationofAllWords {
    //this is my solution,TLE
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || words == null || s.length() == 0 || words.length == 0){
            return null;
        }
        int step = words[0].length();
        int length = step*words.length;
        Arrays.sort(words);
        List<Integer> res = new ArrayList<>();
        String[] tempArray = new String[words.length];
        for(int i = 0; i <= s.length() - length;i++){
            for(int j = 0;j < words.length;j++){
                tempArray[j] = s.substring(i+j*step,i+j*step+step);
            }
            Arrays.sort(tempArray);
            if(Arrays.equals(tempArray, words)){
                res.add(i);
            }
        }
        return res;
    }

    //my solution after optimize,the way to solve the problem is like before,just use hashmap to replace array
    public List<Integer> findSubstring4(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || words == null || s.length() == 0 || words.length == 0){
            return res;
        }
        Map<String,Integer> wordsMap = new HashMap<>(words.length);
        for(String word : words){
            if(wordsMap.containsKey(word)){
                wordsMap.put(word, wordsMap.get(word)+1);
            } else {
                wordsMap.put(word, 1);
            }
        }
        int step = words[0].length();
        int length = step*words.length;
        String temp;
        for(int i = 0; i <= s.length() - length;i++){
            Map<String, Integer> copy = new HashMap<>(wordsMap);
            for(int j = 0;j < words.length;j++){
                temp = s.substring(i+j*step,i+j*step+step);
                if(copy.containsKey(temp)){
                    int count = copy.get(temp);
                    if(count == 1){
                        copy.remove(temp);
                    } else {
                        copy.put(temp, count - 1);
                    }
                    if(copy.isEmpty()){
                        res.add(i);
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }

    /**
     * It's not too hard to find some resemblance between this problem and minimum-window-substring.
     * Actually the main difference is the fact that we are interested at some interval length:
     * we want intervals with fixed length K * M, where K is the number of strings in the "words" array and M the length of each target string.
     * In order to apply the same idea we used for that problem,
     * all we need to do is to map each string from the "words" array to something we are able to index (I prefer to use hashing for this).
     * Also, in order to speed up the algorithm, we can find all occurrences of those strings in S (which is equivalent to do it on demand,
     * but we will potentially do the same matching twice). Notice that, we can simply apply these occurrences as they appear because we are assured that no word is contained by some other.
     * Finally, we use all this information to process each possibility. Notice here that, the fact that all strings has the same length,
     * implies that we have just M (being M the length of each target string) possible starting points, hence we end up performing M linear scans over array with length O(N/M)
     * (being N the length of S) and that makes the scanning stage of the algorithm to be linear on the length of S.
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        int N = s.length();
        List<Integer> indexes = new ArrayList<Integer>(s.length());
        if (words.length == 0) {
            return indexes;
        }
        int M = words[0].length();
        if (N < M * words.length) {
            return indexes;
        }
        int last = N - M + 1;

        //map each string in words array to some index and compute target counters
        Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
        int [][] table = new int[2][words.length];
        int failures = 0, index = 0;
        for (int i = 0; i < words.length; ++i) {
            Integer mapped = mapping.get(words[i]);
            if (mapped == null) {
                ++failures;
                mapping.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int [] smapping = new int[last];
        for (int i = 0; i < last; ++i) {
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        //fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            //reset scan variables
            int currentFailures = failures; //number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / M) ==  words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return indexes;
    }

    /**
     * My idea is pretty simple. Just build a map for the words and their relative count in L. Then we traverse through S to check whether there is a match.
     * At first I was gonna to use a set for words. Owing to the fact that duplicate is allowed in L, we need to use map instead.
     */
    public List<Integer> findSubstring3(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word

        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
    }

    /**
     * 这道题看似比较复杂，其实思路和Longest Substring Without Repeating Characters差不多。
     * 因为那些单词是定长的，所以本质上和单一个字符一样。和Longest Substring Without Repeating Characters的区别只在于我们需要维护一个字典，
     * 然后保证目前的串包含字典里面的单词有且仅有一次。思路仍然是维护一个窗口，如果当前单词在字典中，
     * 则继续移动窗口右端，否则窗口左端可以跳到字符串下一个单词了。假设源字符串的长度为n，字典中单词的长度为l。
     * 因为不是一个字符，所以我们需要对源字符串所有长度为l的子串进行判断。做法是i从0到l-1个字符开始，
     * 得到开始index分别为i, i+l, i+2*l, ...的长度为l的单词。这样就可以保证判断到所有的满足条件的串。
     * 因为每次扫描的时间复杂度是O(2*n/l)(每个单词不会被访问多于两次，一次是窗口右端，一次是窗口左端)，
     * 总共扫描l次（i=0, ..., l-1)，所以总复杂度是O(2*n/l*l)=O(n)，是一个线性算法。空间复杂度是字典的大小，即O(m*l)，
     * 其中m是字典的单词数量。
     */
    public List<Integer> findSubstring5(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S==null || S.length()==0 || L==null || L.length==0)
            return res;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<L.length;i++)
        {
            if(map.containsKey(L[i]))
            {
                map.put(L[i],map.get(L[i])+1);
            }
            else
            {
                map.put(L[i],1);
            }
        }
        for(int i=0;i<L[0].length();i++)
        {
            HashMap<String,Integer> curMap = new HashMap<String,Integer>();
            int count = 0;
            int left = i;
            for(int j=i;j<=S.length()-L[0].length();j+=L[0].length())
            {
                String str = S.substring(j,j+L[0].length());

                if(map.containsKey(str))//首先判断是否包含
                {
                    if(curMap.containsKey(str))//看其是否已经在之前出现过
                        curMap.put(str,curMap.get(str)+1);
                    else
                        curMap.put(str,1);
                    if(curMap.get(str)<=map.get(str))
                        count++;
                    else//如果次数大于map中的次数，则移动左窗
                    {
                        while(curMap.get(str)>map.get(str))
                        {
                            String temp = S.substring(left,left+L[0].length());
                            if(curMap.containsKey(temp))
                            {
                                curMap.put(temp,curMap.get(temp)-1);
                                if(curMap.get(temp)<map.get(temp))
                                    count--;
                            }
                            left += L[0].length();
                        }
                    }
                    if(count == L.length)
                    {
                        res.add(left);
                        //if(left<)
                        String temp = S.substring(left,left+L[0].length());
                        //if(curMap.containsKey(temp))//这个判断有必要吗，我认为一定包含（实测没有必要）
                        curMap.put(temp,curMap.get(temp)-1);
                        count--;
                        left += L[0].length();
                    }
                }
                else
                {
                    curMap.clear();
                    count = 0;
                    left = j+L[0].length();
                }
            }
        }
        return res;
    }

}
