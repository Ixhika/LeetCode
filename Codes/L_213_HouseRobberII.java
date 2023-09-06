package Codes;

public class L_213_HouseRobberII {
    // Recursive function as it is a circular array and there are 2 conditons that is possible
    // This function is normally solving the max sum as done House Robber 1 
    public int helper(int[] nums,int start,int end){
        int rob1 = 0;
        int rob2 = 0;
        int maxRob;
        for(int i=start;i<=end;i++){
            maxRob = Math.max(rob1 + nums[i] , rob2);
            rob1 = rob2;
            rob2 = maxRob;
        }
        return rob2;
    }

    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        // This function is checking whether the robbing is maximum using first element or 2nd element
        /*Conditons
         * IF House[1] robbed then it cannot rob House[n-1] -> House[1]-House[n-1];
         * IF House[2] robbed then it can rob till House[n] -. House[2]-House[n];
         */
        return Math.max(nums[0],Math.max(helper(nums,0,nums.length-2),helper(nums,1,nums.length-1)));
        
    }
}
