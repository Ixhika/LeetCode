import java.util.Arrays;
import java.util.Comparator;

public class L_179_LargestNumber {
    // Time Complexity: O(nlogn) -> extra time due to sorting
    // Space Complexity: O(n) -> as we are making new string array of n length

    public String largestNumber(int[] nums) {

        // Creating a string array to store all the numbers in form of string so that we can just concatenate the elements
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }
        // using custom compaarator operations by java (implementing Comparator interface). our custom comparator preserves transitivity, so the sort is correct.
        Comparator<String> cmp = new Comparator<String>(){
            @Override
            public int compare(String num1 , String num2){
                String s1 = num1 + num2;
                String s2 = num2 + num1;

                return s2.compareTo(s1);
            }
        };

        // Sorting the string array so that the most significant number will be in front
        Arrays.sort(str , cmp);
        
        // There is a minor edge case that comes up when the array consists of only zeroes, so if the most significant number is 0, we can simply return 0. 
        if(str[0].charAt(0) == '0'){
            return "0";
        }
        // Creating a resultant array to store the final ans
        StringBuilder res = new StringBuilder();
        for(String s:str){
            res.append(s);
        }

        return res.toString();
    }
}
