import java.util.Arrays;
// Time Complexity: O(n*m*logk)

public class L_279_PerfectSquares {
    // Creating a dp array that is storing squares of the number and initializing it with -1
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    public int helper(int n,int[] dp){
        if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        // Iterating over the grid to check which squares are used to get the target
        int res = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int sq = i*i;
            // when we use one we are substracting that from target to evaluate the remaining
            int count = 1 + helper(n-sq,dp);
            // Finding the min numbers of perfect required
            res = Math.min(res,count);
        }
        // Storing the result in dp;
        dp[n] = res;

        return res;
    }
}
