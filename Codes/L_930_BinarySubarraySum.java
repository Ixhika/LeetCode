package Codes;

public class L_930_BinarySubarraySum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0;
        int sum = 0;
        int count = 0;
        int temp = 0;

        // Normally calculating sum of elements by traversing over array
        for(int right = 0;right<nums.length;right++){
            sum += nums[right];
            if(nums[right] == 1){
                temp = 0;
            }

            // If array = {1 ,1,1,0,1,0,1} if we calculate sum for 1st 3 it is equal to 3 which is greater than the give goal thus normally moving left pointer front to find correct subarray
            if(sum > goal){
                sum -= nums[left];
                left++;
            }

            // Sliding window method, after finding the correct subarray moving left pointer forward to find another subarrays.
            while(sum == goal && left <=right){
                temp++;
                sum -= nums[left];
                left++;
            }

            // Using temp counter also to store the count of previous subarrays and the adding it to final count
            count += temp;
        }
        return count;
    }
}
