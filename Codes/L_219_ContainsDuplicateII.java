package Codes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class L_219_ContainsDuplicateII {
     public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1 || k == 0){
            return false;
        }
        // Using hashmap to store the key as nums[i] and value as index of the element
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<nums.length;i++){

        // If the map alread contains the number then checking whether the difference of starting pointer and index of the number is <= k
           if(map.containsKey(nums[i])){
               if(i-map.get(nums[i]) <= k){
                   return true;
               }
           }
        //    Adding elements and their values/indexes
           map.put(nums[i],i);
       }
        return false;
    }
}


// Time Limited Exceeded : 47/58 testcases passed
// Brute force 
// for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(nums[i] == nums[j] && Math.abs(i-j) <= k){
//                     return true;
//                 }
//             }
//         }
//         return false;
