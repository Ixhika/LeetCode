import java.util.Arrays;
import java.util.HashMap;

public class L_2418_SortPeople {
     public String[] sortPeople(String[] names, int[] heights) {
        // Creating a hashmap to store the names and heights of the people
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0;i<names.length;i++){
            map.put(heights[i] , names[i]);
        }
        // Sorting the height first
        Arrays.sort(heights);
        // Traversing backward and then storing the names of the people in decsending order
        String[] res = new String[heights.length];
        int idx= 0;
        for(int i=heights.length-1;i>=0;i--){
            res[idx] = map.get(heights[i]);
            idx++;
        }
        return res;
    }
}
