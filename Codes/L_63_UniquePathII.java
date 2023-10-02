package Codes;

import java.sql.Time;

public class L_63_UniquePathII {

/*Complexity Analysis

 Time Complexity: O(M×N)O(M \times N)O(M×N). The rectangular grid given to us is of size M×NM \times NM×N and 
 we process each cell just once.
 Space Complexity: O(1)O(1)O(1). We are utilizing the obstacleGrid as the DP array. Hence, no extra space.*/


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the obstacle is present in the first onlu then there is not path to go thus return 0
        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        // if not then puttin 1st position as 1 and the making 1st row and 1st column 1 if there is no obstacle
        obstacleGrid[0][0] = 1;

        // Row
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Column
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Using the same intution of unique path to find the paths if there is no obstacle
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }else{
                    obstacleGrid[i][j] = 0;    //if in between obstacle comes either assign it zero or the previous value of the column grid[i][j] = grid[i][j-1]
                }
            }
        }
        return obstacleGrid[m-1][n-1];    
    } 
}
