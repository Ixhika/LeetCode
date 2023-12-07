package Codes;

import java.util.Arrays;

public class L_2404_MostFrequentEvenNumber {
    public int mostFrequentEven(int[] nums) {
       Arrays.sort(nums);
       int maxFreq = 0;
       int count = 0;
       int res = -1;
       for(int i=0;i<nums.length;i++){
           if(i == 0 && nums[i] % 2 == 0){
               count++;
           }
           else if(nums[i] % 2 == 0 && nums[i]-nums[i-1] != 0){
               count = 1;
           }
           else if(nums[i] % 2 == 0 && nums[i]-nums[i-1] == 0){
               count++;
           }
           if(count > maxFreq){
               maxFreq = count;
               res = nums[i];
           }
       }
       return res;
    }
}
