package Codes;

import java.util.Arrays;

public class L_1043_PartitionArrayForMaximumSum {
     int n;
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Time Complexity: O(n*k)-We visit only n states in dp array and everytime run a for loop of size k(with memoization)
        n = arr.length;
         dp = new int[n];
         Arrays.fill(dp,-1);
        return solve(arr,k,0);
    }
    public int solve(int[] arr , int k , int idx){
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int res = 0;
        int currMax = -1;
        // i-idx+1 <= k is the maximum length the subarray can be formed
        for(int i=idx;i<n && i-idx+1 <= k;i++){
            // finding the max element in the given subarray
            currMax = Math.max(currMax , arr[i]);

            // current subarray result from i to j. solving this using recursive tree finding the max and calling recursion to check other sums and then finding the largest sum among all
            res = Math.max(res , currMax * (i-idx+1) + solve(arr,k,i+1));
        }
        return dp[idx] = res;
    }
}
