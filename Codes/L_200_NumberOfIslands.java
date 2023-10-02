package Codes;

public class L_200_NumberOfIslands {

    // Time Complexity: O(m*n*4^n) as we are traversing over every sqaure

    public int numIslands(char[][] grid) {
        int count = 0;
        // traversing over the grid to see where islands(1s) are present , if yes we are counting 1 by 1
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    backtrack(grid , i , j);
                    count++;
                }
            }
        }
        return count;
        
    }
    public void backtrack(char[][] grid , int i , int j){
        // Checking out of bounds conditions
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0'){
            return;
        }
        // while traversing through the grid if we visited one land we are making it 0 to prevent it from taking into consideration again
        grid[i][j] = '0';
        // recusrisively checking in all four directions
        backtrack(grid , i+1 , j);
        backtrack(grid , i , j+1);
        backtrack(grid , i-1 , j);
        backtrack(grid , i , j-1);
    }
}
