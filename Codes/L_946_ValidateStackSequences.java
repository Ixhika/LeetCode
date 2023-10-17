package Codes;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n) as we are using stack
public class L_946_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        // Traversing over given pushed array: the elements that are/will be be pushed in stack
        int j = 0;
        for(int val : pushed){
            stack.push(val);

            // According to question it will return true if the stack becomes empty, thus checking the condition if the sequence of stack popping is followed or not that is FIFO.
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();

                // 2nd pointer is for traversing over popped array
                j++;
            }
        }
        return stack.isEmpty();
    }

    // Space Complexity: O(1)

    // public boolean validateStackSequences(int[] pushed, int[] popped) {
    //     // Space Complesity: O(1)
    //     int i=0;
    //     int j = 0;
    //     for(int val:pushed){
    //         pushed[i] = val;
    //         i++;

    //         while(i > 0 && pushed[i-1] == popped[j]){
    //             i--;
    //             j++;
    //         }
    //     }
    //     return i==0;
    // }
}
