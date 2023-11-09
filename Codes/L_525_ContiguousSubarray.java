package Codes;

import java.util.HashMap;

// Thus, we make use of a HashMap mapm to store the entries in the form of (index,count). We make an entry for a count in the map whenever the count is encountered first, and
//  later on use the correspoding index to find the length of the largest subarray with equal no. of zeros and ones when the same countis encountered again.

public class L_525_ContiguousSubarray {
    public int findMaxLength(int[] nums) {

        // Creating a hashmap where index and sum of subarray with equal 0 and 1 is stored
       HashMap<Integer,Integer> map = new HashMap<>();
       map.put(0,-1);
       int maxLength = 0;
       int count =0;

    //    traversing through array to check
       for(int i=0;i<nums.length;i++){
           if(nums[i] == 0){
               count += -1;
           }else{
               count += 1;
           }

        //    Not only this, another point to be noted is that if we encounter the same count twice while traversing the array,
        //     it means that the number of zeros and ones are equal between the indices corresponding to the equal count values
           if(map.containsKey(count)){
               maxLength = Math.max(maxLength , i - map.get(count));
           }else{
               map.put(count , i);
           }
       }
       return maxLength;
    }
}


// Time Complexity: O(n^2): TLE

//  public int findMaxLength(int[] nums) {
//        int maxLen = 0;
//        for(int i =0;i<nums.length;i++){
//            int count_zero = 0;
//            int count_one = 0;

//            for(int j = i;j<nums.length;j++){
//                if(nums[j] == 0){
//                    count_zero++;
//                }else{
//                    count_one++;
//                }
//                if(count_zero == count_one){
//                    maxLen = Math.max(maxLen , j-i+1);
//                }
//            }  
//        } 
//        return maxLen;
//     }