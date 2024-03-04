package Codes;
/*You are given a binary string s that contains at least one '1'.

You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.

Return a string representing the maximum odd binary number that can be created from the given combination.

Note that the resulting string can have leading zeros.

 

Example 1:

Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".
Example 2:

Input: s = "0101"
Output: "1001"
Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining digits is "100". So the answer is "1001".
  */
public class L_2864_MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;

        // Counting total number of ones in the given string
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }

        // iterating all the ones and adding them in resultant string
        StringBuilder res = new StringBuilder();
        for(int i=1;i<count;i++){
            res.append("1");
        }
        // adding all remaining zeroes in string
        for(int i=0;i<s.length()-count;i++){
            res.append("0");
        }

        // and then adding a 1 to keep the resultant string odd
        res.append("1");

        return res.toString();
    }
}
