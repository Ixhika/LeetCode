package Codes;

public class L_121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // Storing first element in a variable and initializing max profit as 0
        int minSoFar = prices[0];
        int maxProfit = 0;

        // Iterating from 2nd element till last and comparing which is a min element
        for(int i=1;i<prices.length;i++){
            minSoFar = Math.min(minSoFar, prices[i]);

            // Calculating difference between min element and next greater element
            int profit = prices[i] - minSoFar;

            // Finding which is having maximum difference that will give us the maximum profit
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
