package Codes;

import java.util.List;
/*You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.
  */
public class L_1239_MaximumLengthOfConcatenatedString {
    int n;
    public int maxLength(List<String> arr) {
        n = arr.size();
        return solve(arr ,"",0,n);
    }

    // making a tree that has two choices that is either we can include the string or exclude the string to form a main string with max length
    public int solve(List<String> arr , String temp , int idx ,int n){
        if(idx >= n){
            return temp.length();
        }
        int include = 0;
        int exclude = 0;

        // if while combining the incoming string it has duplicate element then exclude it and jump to next
        if(isDuplicate(arr.get(idx) , temp)){
            exclude = solve(arr , temp , idx+1 , n);
        }else{
            // if no duplicate then we have two options either take the string or exclude the string
            exclude = solve(arr , temp , idx+1 , n);
            temp += arr.get(idx);
            include = solve(arr , temp , idx+1 , n);
        }
        // return the max length among the included and excluded string
        return Math.max(exclude , include);
    }

    // Checking if the current formed string has characters same as the next incoming string that is why two string arguments has been passed
    public boolean isDuplicate(String s1 , String s2){
        int[] arr = new int[26];
        for(char ch:s1.toCharArray()){
            if(arr[ch - 'a'] > 0){
                return true;
            }
            // counting the freq of each characters 
            arr[ch - 'a']++;
        }
        for(char ch : s2.toCharArray()){
            if(arr[ch - 'a'] > 0){
                return true;
            }
        }
        return false;
    }
}
