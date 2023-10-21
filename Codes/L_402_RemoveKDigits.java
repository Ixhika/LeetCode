package Codes;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)
public class L_402_RemoveKDigits {
    
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        // traversing over string and adding elements to stack according monotonic stack logic
        for(char c : num.toCharArray()){
            while(!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }   
            stack.push(c);   
        }

        // For testcases like "1111" and k = 3
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }

        // Taking new string to store the result
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        // Reversing the res as while following the LIFO property thus to get the result we are performing
        sb.reverse();

        // Removing leading zeroes like "0002"  output is "2"
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
