package Codes;

public class L_896_MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int i=0;
        int j= nums.length-1;

        // First checking for strictly increasing
        if(nums[i] < nums[j]){
            while(i < j){
                if(nums[i] > nums[i+1] || nums[j] < nums[j-1]){
                    return false;
                }
                i++; j--;
            }
            }else{
                // Checking for strictly decreasing
                while(i < j){
                    if(nums[i] < nums[i+1] || nums[j] > nums[j-1]){
                        return false;
                    }
                     i++;
                     j--;
                }
            }
        return true;
     }
}


// Taking two pointers firstly initializing them as true: If one satisfies other is false else vice versa 
//  boolean inc = true;
//  boolean dec =  true;
//  for(int i=1;i<nums.length;i++){
//      if(nums[i] > nums[i-1]){
//          inc = false;
//      }else if(nums[i] < nums[i-1]){
//          dec = false;
//      }

//      if(!inc && !dec){
//          return false;
//      }
//  }
//  return true;