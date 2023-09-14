public class L_62_UniquePath {

    // In question we can move only in two directions either right or down.

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        // putting 1 in the last column as there is only one way to reach there that is going down only
        for(int i=0;i<n;i++){
            dp[m-1][i] = 1;
        }
        // Putting 1 in last row as there is only one way to reach the end point by just going right
        for(int j=0;j<m;j++){
            dp[j][n-1] = 1;
        }
        // Traversing from 2nd last row and column and adding possible ways to reach to the given position
        for(int i=m-2;i>=0;i--){
            for(int j = n-2;j>=0;j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];   //We are returning the first position as we started counting paths from last 
    }
}

// Matrix of 3*7
/*28 21 15 10 6 3 2 1
 * 7 6 5 4 3 2 1
 * 1 1 1 1 1 1 1 
 */
