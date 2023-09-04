package Codes;

import java.util.ArrayList;
import java.util.List;

public class L_39_CombinationSum {
    public void backtrack(int[] candidates,List<List<Integer>> res,List<Integer> temp,int target,int start){
        // Checking base cases if target is zero after calculation/summation of elements in list
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        // if target is -ve then end the function and return void
        if(target < 0){
            return;
        }

        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);    //Not checking if elements are already in list or not as duplicates are allowed.
            backtrack(candidates,res,temp,target-candidates[i],i);    //not doing i+1 as we want to reuse the elements in the list
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates,res,new ArrayList<>(),target,0);
        return res;

    }
}
