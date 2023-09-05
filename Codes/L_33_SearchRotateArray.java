package Codes;

public class L_33_SearchRotateArray {
    // Adavanced Bianry Search For arrays
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if (nums[mid] == target)
                return mid; 

                // If left part is sorted
            if (nums[low] <= nums[mid]) { 
                // Searching if the target lies between any number of left part or is the number in left part of the array
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;   //if not then shifting the mid to right part of the array
            } else {
                // Searching if the target lies between any number of right part or is the number in right part of the array
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;     //if not then shifting the mid to left part of the array
            }
        }
        return -1;      //if element is not present only returning -1
    } 
}
