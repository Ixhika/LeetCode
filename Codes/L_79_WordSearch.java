package Codes;

public class L_79_WordSearch {
    //Time Complexity: O(n*m*4^n)
    // Space Complexity:  
    public boolean exist(char[][] board, String word) {
        // Traversing through the grid and searching for thr letter and matching with given dtring
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if((word.charAt(0) == board[i][j]) && search(board,word,visited,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board,String word,boolean[][] visited,int i,int j,int idx){
        // if the pointer which is started from 0th position becomes equal to word length i.e it has found all letters it will return true
        if(idx == word.length()){
            return true;
        }
        // Checking all out of bounds conditions and if the character is not present in the grid or is not visited
        if(i>=board.length || i<0 || j>=board[i].length || j<0 || board[i][j] != word.charAt(idx) || visited[i][j]){
            return false;
        }
        // Starting the recursive/backtracking and searching for the letter in the grid in all four directions
        visited[i][j] = true;
        if(search(board,word,visited,i-1,j,idx+1)||
        search(board,word,visited,i+1,j,idx+1)||
        search(board,word,visited,i,j+1,idx+1)||
        search(board,word,visited,i,j-1,idx+1)){
            return true;
        }
        visited[i][j] = false;
        return false;

    }
}
