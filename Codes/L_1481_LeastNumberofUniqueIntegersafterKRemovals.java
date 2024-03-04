package Codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class L_1481_LeastNumberofUniqueIntegersafterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i , map.getOrDefault(i , 0)+1);
        }
       List<Integer> res = new ArrayList<>(map.values());
       Collections.sort(res);
       
       int remove = 0;
       for(int i = 0;i<res.size();i++){
           remove += res.get(i);

           if(remove > k){
               return res.size() - i;
           }
       }
       return 0;
    }
}
