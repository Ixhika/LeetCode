package Codes;

// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

public class L_905_SortArrayInParity {
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j = nums.length-1;

        // Starting two pointers one from first and one from last and then checking even and odd and swapping accordingly
        while(i<=j){
            if(nums[i] % 2 == 0){
                i++;
            }else{
                if(nums[j] % 2 == 0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    i++;
                    j--;
                }else{
                    j--;
                }
            }
        }
        return nums;
    }
}
