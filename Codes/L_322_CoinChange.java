package Codes;

import java.util.*;

public class L_322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Checking invalid conditions
        if(coins == null || amount < 0 || coins.length == 0){
            return 0;
        } 
        // Creating a dp array that is storing the amount to be used later
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        // Starting from 1 to amount
        for(int i=1;i<=amount;i++){

            // Taking values from coins[]
            for(int c : coins){

                // Substracting it from the amount
                if(i - c >= 0){
                    
                    // Checking if the already present element in dp is bigger or the recently counted one is bigger
                    dp[i] = Math.min(dp[i] , 1+dp[i-c]);
                }
            }
        }
        if(dp[amount] != amount+1){
            return dp[amount];
        }else{
            return -1;
        }
    }
}
