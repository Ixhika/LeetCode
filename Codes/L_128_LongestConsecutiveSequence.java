package Codes;

import java.util.HashSet;

/*Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.*/

public class L_128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        // Using a hashset to store all the integers of the array
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int longestSeq = 1;
        for(int n : nums){
            // Checking if there is any element that is the starting sequence of the array.
            if(!set.contains(n-1)){
                int count = 1;

                // Checking if the condition of continuous sequence is there or not like 1->2->3..... if there then increase the count by 1
                while(set.contains(n+1)){
                    count++;
                    n++;
                }
                //Calculating the maximum of longest sequence and count of recent sequnece.
                longestSeq = Math.max(longestSeq , count);
            }
        }
        return longestSeq;
    }
    
}
