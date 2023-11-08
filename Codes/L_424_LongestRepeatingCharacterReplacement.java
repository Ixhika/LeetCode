package Codes;

public class L_424_LongestRepeatingCharacterReplacement {
    // Time complexity: O(26*n)
    
    public int characterReplacement(String s, int k) {
        // using classic sliding window approach
        int[] res = new int[26];
        int maxFreq = 0;
        int maxLength = 0;
        int left = 0;

        // finding substrings with valid window size
        for(int right=0; right<s.length(); right++){

            // Counting number of elements for each window
            res[s.charAt(right)-'A']++;

            // Finding max freq
            maxFreq = Math.max(maxFreq , res[s.charAt(right)-'A']);

            // to make a valid window we window size - maxFreq should <= to number of replacements that can be made
           if(right-left+1-maxFreq > k){
            // if not <= k then moving the window size forward
                res[s.charAt(left)-'A']--;
                left++;
            }

            // Find length of longest repeating character
            maxLength = Math.max(maxLength , right-left+1);
        }
        return maxLength;
    }
}
