package Codes;

/*Given a binary string s, return the number of substrings with all characters 1's. 
Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.
Example 2:

Input: s = "101"
Output: 2
Explanation: Substring "1" is shown 2 times in s.*/

public class L_1513_NmberOfSubstringswithOnly1s {
    public int numSub(String s) {
        int count = 0;
        int res = 0;
        int mod = (int) Math.pow(10,9)+7;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                count++;
            }else{
                count = 0;
            }
            res = (res + count) % mod;
        }
        return res;
    }
}
