package Codes;

import java.util.List;

// Recursion+Memoization
// Time complexity: O(n*2^n)
public class L_139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
      int n = s.length();
      
      // if we are using boolean then it is showing TLE because boolean, is the type whose values are either true or false
      // But Booleanthe other is an object and it can be null

      Boolean[] dp = new Boolean[n];
      return solve(s , wordDict , 0 , dp , n);
    }
    public boolean solve(String s , List<String> wordDict , int idx , Boolean[] dp , int n){
        // if idx reaches to last position
      if(idx == n){
        return true;
      }

    //   if dp[idx] is not null it is providing its recent value for further actions
      if(dp[idx] != null){
        return dp[idx];
      }
    //   starting from 1st position in s and the taking one character each time and checking if the new string is present in the given dictionary or not
      for(int end = idx+1;end <= n;end++){
        String str = s.substring(idx , end);
        if(wordDict.contains(str) && solve(s,wordDict,end,dp,n)){
          return dp[idx] = true;
        }
      }
      return dp[idx] = false;
    }

}
