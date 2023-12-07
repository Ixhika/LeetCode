package Codes;

public class L_643_MaximumAverageI {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1 && k == 1){
            return (double)nums[0];
        }
        int left = 0;
        double maxAvg = Integer.MIN_VALUE;
        int sum = 0;
        for(int right = 0;right < nums.length;){
            sum += nums[right];

            while(right - left + 1 == k){
                double avg = (double)sum/k;
                maxAvg = Math.max(maxAvg , avg);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return maxAvg;
    }
}
