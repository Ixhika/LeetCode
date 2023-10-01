package Codes;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)
public class L_32_LongestValidParenthesis {
     public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // First pushing -1 in stack to allow entry of the other indexes
        stack.push(-1);
        int max = 0;
        // Traversing over the string and pushing them in stack according to given condition
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    // Checking the length if total elements popped out to be "()"
                    int len = i - stack.peek();
                    max = Math.max(max , len);           //Finding the max length
                }
            }
        }
        return max;
    }
}
