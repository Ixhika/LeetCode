package Codes;

import java.util.Stack;

public class L_844_BackSpaceStringCompare{
    public boolean backspaceCompare(String s, String t) {
        if(newString(s).equals(newString(t))){
            return true;
        }
        return false;
    }
    public String newString(String s){
       Stack<Character> stack = new Stack<>();
       for(char c:s.toCharArray()){
           if(c != '#'){
               stack.push(c);
           }else if(!stack.isEmpty()){
               stack.pop();
           }
       }
       return String.valueOf(stack);
    }
}
