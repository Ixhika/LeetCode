package Codes;


// Return the sum of all subarray ranges of nums.
// The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

public class L_2104_SumOfSubarrayRanges {
    // Time: O(n^2)
    
    public long subArrayRanges(int[] nums) {
      long sum = 0;
       for(int i=0;i<nums.length;i++){
        // taking these inside for loop because everytime the values will start calculating from the beginning for every value in given num 
           int j = i;
           int min = nums[i];
           int max = nums[i];
            while(j < nums.length){

                // calculating min and max of specific range and then solving according to given condition
                min = Math.min(min , nums[j]);
                max = Math.max(max , nums[j]);
                sum += max - min;
                j++;
            }
       }
       return sum;
    }
}
