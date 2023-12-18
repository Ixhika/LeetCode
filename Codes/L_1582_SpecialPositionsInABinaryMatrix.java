package Codes;

/**
 * L_1582_SpecialPositionsInABinaryMatrix
 */
public class L_1582_SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                // traversing through the 2d matrix and checking where there is 1,if present we are increasing the count of row and col array
                if(mat[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        // if there are only one 1 and count of 1 in row array and column array is 1 then counting that specific pos
        int specialPos = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    specialPos++;
                }
            }
        }
        // returning number of columns with single 1
        return specialPos;
    }
}