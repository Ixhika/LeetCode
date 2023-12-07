package Codes;

import java.util.List;

public class L_1239_MaximumLengthOfConcatenatedString {
    int n;
    public int maxLength(List<String> arr) {
        n = arr.size();
        return solve(arr ,"",0,n);
    }
    public int solve(List<String> arr , String temp , int idx ,int n){
        if(idx >= n){
            return temp.length();
        }
        int include = 0;
        int exclude = 0;
        if(isDuplicate(arr.get(idx) , temp)){
            exclude = solve(arr , temp , idx+1 , n);
        }else{
            exclude = solve(arr , temp , idx+1 , n);
            temp += arr.get(idx);
            include = solve(arr , temp , idx+1 , n);
        }
        return Math.max(exclude , include);
    }
    public boolean isDuplicate(String s1 , String s2){
        int[] arr = new int[26];
        for(char ch:s1.toCharArray()){
            if(arr[ch - 'a'] > 0){
                return true;
            }
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
