package Codes;

import java.util.Arrays;

public class L_2341_MaximumPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=1;i<nums.length;){
            if(nums[i] == nums[i-1]){
                count++;
            }else{
                i--;
            }
            i+=2;
        }

        return new int[] {count , nums.length-(2*count)};
    }
}
