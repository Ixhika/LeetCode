import java.util.Arrays;

public class L_135_Candy {
     public int candy(int[] ratings) {
        if(ratings.length == 1){
            return 1;
        }
        int n = ratings.length;
        // Making a dp for storing the number of candies
        int[] dp = new int[n];

        // filling the dp with 1 as it is satisfying condition one that every rating will have have atleast 1 candy
        Arrays.fill(dp,1);
        boolean flag = true;  //using this just to keep a check
        while(flag){
            flag = false;
            for(int i=0;i<n;i++){

                /*if the current element's rating, ratings[i], is larger than the previous element ratings[i - 1] and 
                additionally candies[i] <= candies[i - 1], then we update candies[i] as candies[i] = candies[i - 1] + 1.*/

                if(i!=n-1 && ratings[i] > ratings[i+1] && dp[i] <= dp[i+1]){
                    dp[i] = dp[i+1] + 1;
                    flag = true;
                }
                /*now the candy distribution for these two elements candies[i - 1] and candies[i] becomes correct for the time being (locally).
                 In the same step, we also check if the current element's ratings, ratings[i], is larger than the next element's ratings, i.e. 
                 ratings[i] > ratings[i + 1]. If so, we again update candies[i] = candies[i + 1] + 1 */

                if(i>0 && ratings[i] > ratings[i-1] && dp[i] <= dp[i-1]){
                    dp[i] = dp[i-1] + 1;
                    flag = true;
                }
            }
        }
        // Just summing up the elements in the dp to calculate total candies
        int sum = 0;
        for(int candy:dp){
            sum += candy;
            }
        return sum;
    }
}
