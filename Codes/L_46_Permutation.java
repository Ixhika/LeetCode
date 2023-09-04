package Codes;

import java.util.ArrayList;
import java.util.List;

public class L_46_Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(),res,nums);
        return res;
    }
    public void backtrack(List<Integer> temp,List<List<Integer>> res,int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i:nums){
            // As no duplicates allowed so we are checking if the element is already present in the list or not. If no then adding in temp
            if(!temp.contains(i)){
                temp.add(i);

                // Calling a recusrsive function and storing all possible permutations
                backtrack(temp,res,nums);

                // If the permutation is not correct we are removing the last element to add another and check the combination again
                temp.remove(temp.size()-1);
            }
        }
    }
}
