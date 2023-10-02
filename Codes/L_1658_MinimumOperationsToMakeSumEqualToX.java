package Codes;

public class L_1658_MinimumOperationsToMakeSumEqualToX {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    /*arr: [1,1,4,2,3] x = 5 */
    public int minOperations(int[] nums, int x) {
        // Calculating total sum of the array: sum = 11, sum-x=6 we will be calculating for 6 and then in the end for result we will substract from total length to get the elements that actually used
        int sum = 0;
       for(int i=0;i<nums.length;i++){
           sum += nums[i];
       }
    //    Starting 2 pointers left and right both from zero , basically using sliding window
       int currSum= 0;
       int window = -1;
       int left = 0;
    //    traversing right till it satisfys the conditions
       for(int right = 0;right<nums.length;right++){
           currSum += nums[right];
        // if not removing the elements from left 
           while(left <= right && currSum > (sum-x)){
               currSum -= nums[left];
               left++;
           }
        //    if true returnig maximum length that brings currSUm == sum-x
           if(currSum == (sum-x)){
               window = Math.max(window , right-left+1);
           }
       }
       if(window == -1){
           return -1;
       }else{
        // returning ans for actual x
           return nums.length-window;
       }
    }
}
