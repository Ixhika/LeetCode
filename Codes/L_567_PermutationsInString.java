import java.util.Arrays;

public class L_567_PermutationsInString {
    public boolean checkInclusion(String s1, String s2) {
        // Creating one array of size 26(containing all alphabets from a to b) and counting the number of elements in string 1
        int[] count = new int[26];
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i) - 'a']++;         //Subtracting 'a' to prevent out of bounds index as in array 'a' will be at 0th and 'z' will be at 25th position
        }

        // Creating one array of size 26(containing all alphabets from a to b) and counting the number of elements in string 2
        int[] count2 = new int[26];
        for(int i=0;i<s2.length();i++){
            count2[s2.charAt(i) - 'a']++;

            // TO bring the count size equal to string 1 we using this conditon which at the end will give same count if true as in string 1
            if(i >= s1.length()){
                count2[s2.charAt(i - s1.length()) - 'a']--;
            }

            // Using built in function of array.equals to check if freq is equal or not
            if(Arrays.equals(count,count2)){
                return true;
            }
        }
        return false;
    }
}
