package Codes;

public class L_154_MinimumInRotatedArrayII {
    public int findMin(int[] nums) {
        int left = 0;
       int right = nums.length-1;

       if(nums[left] < nums[right]){
           return nums[0];
       }

       while(left<=right){
           int mid = left +(right-left)/2;

        // If mid is greater than last element that means left side is sorted and in right side checking will be done 
         if(nums[mid] > nums[right]){
             left = mid+1;
         }
        // If mid is less than first element in rotated array then we will search min in left part by removing the right side when we are making right = mid
         else if(nums[mid] < nums[left]){
             right = mid;
         }
         else{
           // If at any point mid <= end we are reducing the value of end by 1 and rechecking the conditon of minimum element.
            right--;
         }
       }
       return nums[left];
   }
}
