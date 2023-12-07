package Codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L_1743_RestoreArrayFromAdjacentPairs {
    // creating a public hashmap to store the list of elements of the given 2D array
    HashMap<Integer , List<Integer>> map = new HashMap();

    public int[] restoreArray(int[][] adjacentPairs) {
        // Storing the elements and its neighbors using normal traversal
        for(int[] edge:adjacentPairs){
            int x = edge[0];
            int y = edge[1];
        

            if(!map.containsKey(x)){
                map.put(x, new ArrayList());
            }

            if(!map.containsKey(y)){
                map.put(y , new ArrayList());
            }

            map.get(x).add(y);
            map.get(y).add(x);
        }

        // Finding a start point the point which has only one neighbor and then traversing through all
        int startPoint = 0;
        for(int i : map.keySet()){
            if(map.get(i).size() == 1){
                startPoint = i;
                break;
            }
        }

        int[] res = new int[map.size()];
        dfs(startPoint , Integer.MAX_VALUE , res , 0);

        return res;
    }

    // applying simple dfs traversal that we do in graph
    public void dfs(int curr , int prev , int[] visited , int i){
        visited[i] = curr;
        for(int num : map.get(curr)){
            if(num != prev){
                dfs(num , curr , visited , i+1);
            }
        }
    }
}
