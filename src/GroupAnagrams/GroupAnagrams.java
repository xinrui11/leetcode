package GroupAnagrams;

import java.util.*;

/**
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
     ["ate", "eat","tea"],
     ["nat","tan"],
     ["bat"]
 ]
 */
public class GroupAnagrams {
    // my solution, the idea is very simple, but it's TLE,
    // Time Complexity: O(NKlog(K)Klog(K)), where N is the length of strs,
    // and K is the maximum length of a string in strs.
    // Klog(K)*Klog(K) because i sorted strs twice
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, strs);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < stringList.size(); ) {
            List<String> temp = new ArrayList<>();
            temp.add(stringList.get(i));
            for (int j = i+1; j < stringList.size(); ) {
                if(compare(stringList.get(i), stringList.get(j))){
                    temp.add(stringList.get(j));
                    stringList.remove(j);
                } else {
                    j++;
                }
            }
            stringList.remove(i);
            res.add(temp);
        }
        return res;
    }
    private Boolean compare(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        for (int i = 0; i < s1Array.length; i++) {
            if(s1Array[i] != s2Array[i]){
                return false;
            }
        }
        return true;
    }

    //Solutions in discuss,Time Complexity: O(NKlog(K))
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String ss = String.valueOf(c);
            if(map.containsKey(ss)){
                map.get(ss).add(s);
            } else {
                map.put(ss, new ArrayList<>());
                map.get(ss).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
}
