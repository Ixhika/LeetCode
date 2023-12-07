package Codes;

public class L_2414_LengthOfLongestContinuousSubstring {
    // Time: o(n)
    // Space: O(1)
    public int longestContinuousSubstring(String s) {
        int len = 1;
        int max = 1;
        for(int i=1;i<s.length();i++){
            // When you perform arithmetic operations like subtracting two characters obtained using charAt(), such as s.charAt(i) - s.charAt(i - 1), you're essentially subtracting their underlying ASCII values
            //if you write char c = s.charAt(i);, this retrieves the character at index i from the string s and stores it in the variable c 
            if(s.charAt(i) - s.charAt(i-1) == 1){
                len++;
                max = Math.max(max,len);
            }else{
                len = 1;
            }
        }
        return max;
    }
}
