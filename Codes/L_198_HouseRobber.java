package Codes;

public class L_198_HouseRobber {
     public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        // if array length is 2 then finding the maximum of 2 elements
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        // Creating a dp of same size as nums and setting 0th and 1st position of dp for later calculations and comparisons
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        // Starting from 3rd element and finding its previous and 2nd last previous + actual value in nums maximum and then storing that in ith position of the dp 
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        // In the end of the loop the last element of the dp will be the maximum money robbed thus returning the last element.
        return dp[nums.length-1];
    }
}
