package Codes;
import java.util.*;
public class L_1930_UniquePalindromeSubsequenceOfLength3 {
    public int countPalindromicSubsequence(String s) {
        // putting all unique elements from string to a set
        Set<Character> uniqueLetters = new HashSet<>();
        for(char c:s.toCharArray()){
            uniqueLetters.add(c);
        }

        int res = 0;

        // accessing each letter one by one and finding their first and last index
        for(char c:uniqueLetters){
            int start = -1;
            int end = -1;

            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == c){
                    start = i;
                }
                end = i;
            }

            // then counting all the palindrome subsequences in between the chosen letter's 1st and last index
            Set<Character> count = new HashSet<>();
            for(int j = start+1;j<=end-1;j++){
                count.add(s.charAt(j));
            }
            res += count.size();
        }

        // returning total number of subsequences
        return res;
    }
}
