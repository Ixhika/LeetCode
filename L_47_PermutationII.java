import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_47_PermutationII {
     public void backtrack(List<Integer> temp, List<List<Integer>> res, int[] nums,boolean[] used){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            // Creating a boolean array to keep check on duplicate/repeated element.If already used the also continue. It is storing the element that has already been used
           if(used[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;  //Checking if in the given array another duplicate of the used element is present the also continue. If not the also continue
            used[i] = true;   //making boolean [i] true then adding it in list to ensure that element is added
            temp.add(nums[i]);
            backtrack(temp,res,nums,used);
            used[i] = false;    //To verify if not a permutation then making the duplicate false and removing it from the list.
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(new ArrayList<>(),res,nums,used);
        return res;
    }
}
