package ImplementstrStr;

/**
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 */
public class ImplementstrStr {
    //this solution will be TLE
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        for(int i = 0; i < haystack.length();i++){
            for(int j = 0,k = i;j < needle.length() && k < haystack.length();j++,k++){
                if(haystack.charAt(k) == needle.charAt(j)){
                    if(j == needle.length() - 1){
                        return i;
                    }
                } else{
                    break;
                }
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        for(int i = 0; i < haystack.length();i++){
            for(int j = 0;j < needle.length();j++){
                if(i+j>=haystack.length()){
                    return -1;
                }
                if(haystack.charAt(i+j) == needle.charAt(j)){
                    if(j == needle.length() - 1){
                        return i;
                    }
                } else{
                    break;
                }
            }
        }
        return -1;
    }

    public int strStr3(String haystack, String needle) {
        for(int i = 0;;i++){
            for(int j = 0;;j++){
                //pay attention to the judge order
                if(j == needle.length()){
                    return i;
                }
                if(i + j >= haystack.length()){
                    return -1;
                }
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
        }
    }

    public int strStr4(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
