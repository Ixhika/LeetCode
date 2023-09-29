package Codes;

import java.util.HashMap;
// Time complexity : O(n) The entire nums array is traversed only once.

// Space complexity : O(n) Hashmap map can contain up to nnn distinct entries in the worst case.


public class L_560_SubarraySumEqualsToK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        // Best case if sum is zero count is 1
        map.put(0,1);

        //Finding sum at specific indexes and then keeping a track of their count
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum , map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
