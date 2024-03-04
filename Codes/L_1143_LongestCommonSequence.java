package Codes;
/*Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters. */
public class L_1143_LongestCommonSequence {
//Time: O(m*n)

    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];

        return solve(text1 , text2 , 0, 0);
    }
    public int solve(String text1 , String text2 , int i , int j){
        // Base case: If either of the strings is exhausted, return 0
        if(i == text1.length() || j == text2.length()){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
         // If the characters at the current positions in both strings are the same
         // Include the common character in the LCS and move to the next characters in both strings
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] =  1+solve(text1 , text2 , i+1 , j+1);
        }
        else{
            // If characters are different, explore two possibilities:
        // 1. Move to the next character in text1 and keep text2 unchanged
        // 2. Move to the next character in text2 and keep text1 unchanged
        // Return the maximum length obtained from these two possibilities
            return dp[i][j] =  Math.max(solve(text1 , text2 , i,j+1),solve(text1 , text2 , i+1 , j));
        }
    }
}
