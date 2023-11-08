package Codes;

import java.util.ArrayList;
import java.util.List;

public class L_547_NmberOfProvinces {

    // By creating a graph out of the given 2D matrix and then solving it
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int countProvince = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,visited,i);
                countProvince++;
            }
        }

        return countProvince;
    }

    public void dfs(List<List<Integer>> graph,boolean[] visited, int curr){
        visited[curr] = true;

        for(int i : graph.get(curr)){
            if(!visited[i]){
                dfs(graph,visited,i);
            }
        }
    }
}


// Directly traversing the 2D matrix
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         int countProvince = 0;

//         boolean[] visited = new boolean[n];
//         for(int i=0;i<n;i++){
//             if(!visited[i]){
//                 dfs(isConnected,visited,i);
//                 countProvince++;
//             }
//         }
//         return countProvince;
//     }
//     public void dfs(int[][] isConnected ,boolean[] visited, int curr){
//         visited[curr] = true;

//         for(int i =0;i<isConnected.length;i++){
//             if(isConnected[curr][i] == 1 && !visited[i]){
//                 dfs(isConnected,visited,i);
//             }
//         }
//     }
// }
