package Codes;

import java.util.HashMap;

public class L_523_ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Defining a hashmap that takes in remainder and index at which remainder is found . We are taking index because the subarray that will be true should be of size 2 atleast
       HashMap<Integer,Integer> map = new HashMap<>();

       int prefixSum = 0;
       for(int i=0;i<nums.length;i++){

        // Finding the sum and remainder of the elements in array
           prefixSum += nums[i];
           prefixSum = prefixSum % k;

        // For testcase like [2,4,3] where the remainder is coming zero at index 1 and the length of subarray is techincally 2 but according rules of indexing in array it give 1-0 = 1 thus using condition i>0
           if(prefixSum == 0 && i > 0){
               return true;
           }
        //    if the map already contains the remainder of the prefixSum and the length is >=2 thus return true;
            if(map.containsKey(prefixSum) && i-map.get(prefixSum) >1){
                return true;
            }

            // Else store the remainder and the index
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
       }
        return false;
    }
}

// TLE
 // for(int i=0;i<nums.length;i++){
        //     int sum = nums[i];

        //     for(int j = i+1;j<nums.length;j++){
        //         sum += nums[j];

        //         if(sum % k == 0){
        //             return true;
        //         }
        //     }
        // }
        // return false;
