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
 */
import java.util.ArrayList;
import java.util.List;

class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(getAnagram("cbaebabacd", "abc"));
        System.out.println(getAnagram("fish", "cake"));
        System.out.println(getAnagram("abab", "ab"));   
    }
    public static List getAnagram(String s, String p){
        int pLength = p.length();
        int sLength = s.length();
        char[] pArray = p.toCharArray();
        List startIndList = new ArrayList<>();
        int startSIndex = 0;
        getIsAnagramOfP(s, pLength, pArray, startIndList, startSIndex, sLength);
        return startIndList;
    }
    private static void getIsAnagramOfP(String s, int pLength, char[] pArray, List startIndList, int startSIndex, int sLength) {
        int endInd = startSIndex + pLength;
        if(endInd <= sLength) {
            String subStringValue = s.substring(startSIndex, endInd);
            boolean isAnagramOfP = false;
            for (char c : pArray) {
                if(subStringValue.contains(String.valueOf(c))){
                    isAnagramOfP = true;
                } else {
                    isAnagramOfP = false;
                    break;
                }
            }
            if(isAnagramOfP){
                startIndList.add(startSIndex);
            }
            startSIndex++;
            getIsAnagramOfP(s, pLength, pArray, startIndList, startSIndex, sLength);
        }
    }
}