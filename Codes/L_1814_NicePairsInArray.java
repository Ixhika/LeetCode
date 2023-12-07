package Codes;

import java.util.HashMap;

// Time complexitu: O(n)

public class L_1814_NicePairsInArray {
     public int countNicePairs(int[] nums) {
        // Regrouping
        int mod = (int) Math.pow(10,9)+7;
       int[] update_arr = new int[nums.length];
       for(int i=0;i<nums.length;i++){
           update_arr[i] = nums[i] - reverse(nums[i]);
       }
        // System.out.println(update_arr);
       int res = 0;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int n:update_arr){
        // if num already exist adding the count to result
           res = (int)(res + map.getOrDefault(n,0)) % mod;

        //    updating the count of the num
           map.put(n , map.getOrDefault(n,0)+1);
       }
    //    System.out.println(map);
       return res;
    }
    public int reverse(int n){
        int rev = 0;
        while(n > 0){
            int digit = n%10;
            rev = rev * 10 + digit;
            n = n/10;
        }
        return rev;
    }
}


// Brute force applied but TLE occured as the values are given very big so n^2 solution not a good approach