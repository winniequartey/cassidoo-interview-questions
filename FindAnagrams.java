/**
 * Cassidoo Interview question of the week @ https://buttondown.com/cassidoo/archive/if-you-are-interested-in-what-you-do-that-keeps/
 * Question:
    * Given two strings, s and p, return an array of all the start indices of p's anagrams in s.
    * Examples:
    * findAnagrams("cbaebabacd", "abc")
    * > [0, 6]
    * findAnagrams("fish", "cake")
    * > []
    * findAnagrams("abab", "ab")
    * > [0, 1, 2]
 * Solution: https://www.jdoodle.com/ia/1Ba6
 */
import java.util.ArrayList;
import java.util.List;

class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(getAnagramIndices("cbaebabacd", "abc"));
        System.out.println(getAnagramIndices("fish", "cake"));
        System.out.println(getAnagramIndices("abab", "ab"));   
        System.out.println(getAnagramIndices("babab", "abb"));   
    }
    public static List<Integer> getAnagramIndices(String s, String p){
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }
        int pLength = p.length();
        int sLength = s.length();
        char[] pArray = p.toCharArray();
        List<Integer> startIndList = new ArrayList<>();
        getStartIndiceIfAnagramOfPLoop(s, pLength, pArray, startIndList, sLength);
        return startIndList;
    }

    private static void getStartIndiceIfAnagramOfPLoop(String s, int pLength, char[] pArray, List<Integer> startIndList, int sLength) {
        int endInd = 0;
        String subStringValue = "";
        for (int startSIndex = 0; (startSIndex + pLength) <= sLength; startSIndex++) {
            endInd = startSIndex + pLength;
            subStringValue = s.substring(startSIndex, endInd);
            boolean isAnagramOfP = false;
            for (char c : pArray) {
                if(subStringValue.contains(String.valueOf(c))){
                    subStringValue = subStringValue.replaceFirst(String.valueOf(c), "");
                    isAnagramOfP = true;
                } else {
                    isAnagramOfP = false;
                    break;
                }
            }
            if(isAnagramOfP){
                startIndList.add(startSIndex);
            }
        }
    }
}