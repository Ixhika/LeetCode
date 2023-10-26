package Codes;

/*Intution

Case 1 : mid lies on the right of our result peak ( Observation : Our peak element search space is leftside )
Case 2 : mid is equal to the peak element ( Observation : mid element is greater than its neighbors )
Case 3 : mid lies on the left. ( Observation : Our peak element search space is rightside )*/

/*Some base cases :

The array could be strictly increasing or strictly decreasing and as we have to return any of the possible peaks,
 so we could add a condition to check whether the 1st element/last element could be the peak ).
This point is also supported by the fact that, we are looking for mid-1/ mid+1 ( and these indices are compremised for 0th index / n-1 th index respectively*/

public class L_162_PeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0){
            return 0;
        }if(nums.length ==1){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left + (right - left)/2;

            // Left sorted check if there is peak element when mid > 0
            if(mid > 0 && nums[mid] < nums[mid-1]){
                right = mid-1;

                // Right sorted array check when mid is less than the rightmost position of the array.
            }else if(mid < nums.length-1 && nums[mid] < nums[mid+1]){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }
}


// ITERATIVE METHOD

// class Solution {
//     public int findPeakElement(int[] nums) {
//         if(nums.length == 1){
//             return 0;
//         }
//         if(nums[0] > nums[1]){
//             return 0;
//         }
//         if(nums[nums.length-1] >= nums[nums.length-2]){
//             return nums.length-1;
//         }

//         for(int i =1;i<nums.length;i++){
//             if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

