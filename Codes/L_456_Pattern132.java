package Codes;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)

// For better understanding refer to leetcode animation

public class L_456_Pattern132 {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3){
            return false;
        }

        // Creating a stack and a empty min array from where the comparisons will start.
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            min[i] = Math.min(min[i-1] , nums[i]);
        }
        for(int j=nums.length-1; j>=0 ;j--){
            if(nums[j] > min[j]){
                while(!stack.isEmpty() && stack.peek() <= min[j]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[j]){
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }
}


// TIME LIMITED EXCEEDED after 101th testcase
// int i = Integer.MAX_VALUE;
//         for(int j=0;j<nums.length-1;j++){
//             i = Math.min(i,nums[j]);
//             for(int k=j+1;k<nums.length;k++){
//                 if(nums[k] < nums[j] && i < nums[k]){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

// TIME LIMITED EXCEEDED After 93rd testcase
// for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 for(int k=j+1;k<nums.length;k++){
//                     if(nums[i] < nums[k] && nums[k] < nums[j]){
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
