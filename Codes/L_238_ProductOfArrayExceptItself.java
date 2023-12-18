package Codes;

/*Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0] */

// Time Complexity: O(n)
// Space Complexity: O(n)
public class L_238_ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixPro = new int[len];
        int[] suffixPro = new int[len];
        int pro = 1;

        // in this the prefix array become = [1 , 1 , 2 , 6]
        for(int i=0;i<len;i++){
            prefixPro[i] = pro;
            pro *= nums[i];
        }

        // in this suffix array become = [24 , 12 , 4 , 1]
        pro = 1;
        for(int i=len-1;i>=0;i--){
            suffixPro[i] = pro;
            pro *= nums[i];
        }
        // multiplying both prefix and suffix pro and getting the res
        for(int i=0;i<len;i++){
            nums[i] = prefixPro[i] * suffixPro[i];
        }
        return nums;
    }
}
