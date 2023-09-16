public class L_209_MinimumSizeSubarraySum {
    /*Using sliding window approach as we have to keep checking the window size and return the minimum window size */
    public int minSubArrayLen(int target, int[] nums) {
        // Initialising left pointer at the start of the array and sum=0 and declaring res which stores max value;
        int left = 0;
        int total = 0;
        int res = Integer.MAX_VALUE;

        // Starting a right pointer from start of the array and finding sum of elements that is >= target
        for(int right=0;right<nums.length;right++){
            total += nums[right];

            while(total >= target){
                // finding the length of the subarray which has to be minimum
                res = Math.min(right-left+1,res);

                // If there are other smaller window size possible then by storing the previous length incrementing left pointer by 1 and removing the previous left pointer value from total
                total -= nums[left];
                left++;
            }
        }
        // After calculation if res is max value only then returning 0 
        if(res == Integer.MAX_VALUE){
            return 0;
        }else{
            return res;  //else the size of the window
        }
    }
}
