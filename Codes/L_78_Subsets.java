package Codes;

import java.util.ArrayList;
import java.util.List;

// Time Complexity = O(n*2^n)
// Space Complexity = O(n)
public class L_78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums,0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums,int start){
        // this condition is checking out of bounds conditon
        if(start >= nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        // first line adding the empty list which is also counted as a subset
        res.add(new ArrayList<>(temp));
        // traversing through the array and adding elements one by one 
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
