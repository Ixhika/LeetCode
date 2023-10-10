package Codes;

public class L_680_ValidPalindromeII {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public boolean validPalindrome(String s) {
        // abca: True
        int i=0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                // abcdecba: True(we can remove either 'e' or 'd' to make it palindrome)
                // Condition for skipping the element and the checking palindrome
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
        }
        return true;
    }

    // Checking if string is palindrome or not
    public boolean isPalindrome(String s ,int i,int j){
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
