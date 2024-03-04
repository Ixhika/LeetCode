package Codes;
/*Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.

 

Example 1:

Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.
Example 2:

Input: words = ["notapalindrome","racecar"]
Output: "racecar"
Explanation: The first and only string that is palindromic is "racecar".
Example 3:

Input: words = ["def","ghi"]
Output: ""
Explanation: There are no palindromic strings, so the empty string is returned.
  */
public class L_2108_FindFirstPalindromicStringInAnArray {
    public String firstPalindrome(String[] words) {
        for(String i:words){
            if(IsPalindrome(i)){
                return i;
            }
        }
        return "";
    }
    public boolean IsPalindrome(String word){
        String rev = "";
        for(int i=word.length()-1;i>=0;i--){
            char ch = word.charAt(i);
            rev = rev + ch;
        }
        if(rev.equals(word)){
            return true;
        }
        return false;
    }
}

/*Therefore, the overall time complexity can be expressed as O(n + m), where n is the total number of characters in all words combined, and m is the length of the longest word.

However, we can simplify this to O(n) since the loop for checking palindromes is nested inside the loop for iterating through words. */
