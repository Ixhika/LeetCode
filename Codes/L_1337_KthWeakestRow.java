import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_1337_KthWeakestRow {
     public int[] kWeakestRows(int[][] mat, int k) {
       int m = mat.length;
       int n = mat[0].length;
    //    Creating an array to store the count of all 1s in each row
       int[] count = new int[m];
    //    Result for printing the list of rows with least 1s/Weakest row
       int[] res = new int[k];

       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
            // Counting number of 1s in each row
               count[i] += mat[i][j];
           }
       }
    //    Creating a map and storing row and number of 1s in that specific row
       Map<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<m;i++){
           map.put(i,count[i]);
       }

    //    Converting the map into list using built-in functions
       List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

    //    Sorting the list by comparing values with each other
       Collections.sort(list,Map.Entry.comparingByValue());

    //    traversing over the list and printing the least ones
       for(int i =0;i<k;i++){
           res[i] = list.get(i).getKey();
       }
       return res;
    }
}
