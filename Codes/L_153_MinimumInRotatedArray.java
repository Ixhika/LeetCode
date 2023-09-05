package Codes;

public class L_153_MinimumInRotatedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        // If the array is not rotated and the array is already sorted then it will return 1st element
        if(nums[left] < nums[right]){
            return nums[0];
        }

        // Using Binary Search
        while(left<=right){
            int mid = left +(right-left)/2;

            // If only two element in the array then return mid after checking mid>0 to prevent index out of bounds of -1 as the array is already sorted [1,2] min is 1 only
            if(mid > 0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            // if left side is sorted and then it will go to the right unsorted part and will find new mid and min from right side
           if(nums[mid] >= nums[left] && nums[mid] > nums[right]){
               left = mid +1;
           }else{
            // ELse will got to left side and find the min
               right = mid-1;
           }
        }

        // After all conditions satisfies it will return the left as this pointer will store the min of all number.
        return nums[left];
    }
}
