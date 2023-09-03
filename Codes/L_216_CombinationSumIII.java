package Codes;

import java.util.ArrayList;
import java.util.List;

public class L_216_CombinationSumIII {
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int k,int start,int n){
        // Checking the condition whether the list size is equal to k and the the target has been reduced to zero or not after calculations
       if(temp.size() == k && n==0){
           res.add(new ArrayList<>(temp));
           return;
       }
    //    Running a loop from 1-9 to create all possible combinations for the target
       for(int i=start;i<=9;i++){
           temp.add(i);

        /*  Doing a recursive call which is reducing our target
        // eg: if 1 is added to the list so n =7 now after one elemnet added we will reduce the target by i.
         using this we will reach a list that will check whether the additon of elements in list resulted the target to be zero or not*/

           backtrack(res,temp,k,i+1,n-i);
           temp.remove(temp.size()-1);    //reducing the size of list once the element is added to avoid duplicates.
       }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<Integer>(),k,1,n);
        return res;
    }
}
