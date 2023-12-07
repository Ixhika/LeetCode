package Codes;

/*The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.*/

public class L_1446_ConsecutiveCharacters {
    public int maxPower(String s) {
        if(s.length() == 1){
            return 1;
        }
        if(s.length() == 2){
            return 2;
        }
       int count = 1;
       int maxLength = 0;
    
       for(int i = 1;i<s.length();i++){
           if(s.charAt(i) == s.charAt(i-1)){
               count++;
           }else{
               count = 1;
           }
           maxLength = Math.max(maxLength , count);
       } 
       return maxLength;
    }
}
