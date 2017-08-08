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

}
