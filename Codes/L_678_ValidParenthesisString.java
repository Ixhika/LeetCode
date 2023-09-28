package Codes;

import java.util.Stack;

public class L_678_ValidParenthesisString {
    public boolean checkValidString(String s) {
       Stack<Integer> isParameterStack = new Stack<>();
       Stack<Integer> starstack = new Stack<>();
       for(int i=0;i<s.length();i++){

        // // index of opening
           if(s.charAt(i) == '('){
               isParameterStack.push(i);

               // if we have brackets: "()"
           }else if(s.charAt(i) == ')'){
               if(isParameterStack.size() > 0){
                   isParameterStack.pop();
               }
               // if we do not brackets but we have stars which can be either ')' or '(' or ''
               else if(starstack.size() > 0){
                   starstack.pop();
               }else{
                // a closing bracket without opening and star
                   return false;
               }
           }else{
             // index of star
               starstack.push(i);
           }
       }

        // if we left with some opening bracket that over stars con cover up: "(()(*)"
       while(isParameterStack.size() > 0 && starstack.size() > 0){
           if(isParameterStack.peek() > starstack.peek()){
                return false;
           }
               isParameterStack.pop();
               starstack.pop();
       }
    // When the whole string is read and all parameters have become valid we will return true
       return isParameterStack.size() == 0;
    }
}


// Greedy Method using single loop 
// Time Complexity: O(n)

// int leftMin = 0;
//  int leftMax = 0;
//  for(int i=0;i<s.length();i++){
//      if(s.charAt(i) == '('){
//          leftMin++;
//          leftMax++;
//      }
//      else if(s.charAt(i) == ')'){
//          leftMax -= 1;
//          leftMin -= 1;
//      }
//      else{
//          leftMin -= 1;
//          leftMax += 1;
//      }
//      if(leftMin < 0){
//          leftMin = 0;
//      }
//      if(leftMax < 0){
//          return false;
//      }
//  }
//  return leftMin == 0;
