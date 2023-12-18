package Codes;

import java.util.HashMap;

public class L_2958_LongestSubarrayWithAtmostKFrequency{
    // Simple sliding window concept using map
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for(int right = 0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.get(nums[right]) > k){
                map.put(nums[left] , map.get(nums[left])-1);
                left++;
            }
            
            maxLen = Math.max(maxLen , right-left+1);
        }
        return maxLen;
    }
}
