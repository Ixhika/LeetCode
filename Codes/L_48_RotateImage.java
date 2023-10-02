package Codes;

public class L_48_RotateImage {
    // Time Complexity: O(n*n)
    // Space Complexity: O(1)

    public void rotate(int[][] matrix) {
        // Starting two pointers: one from left and another from end right of grid
        int left = 0;
        int right = matrix.length-1;
        while(left < right){
            // Storing them in one as later left and right are getting updated
            int top = left;
            int bottom  = right;
            // running a loop till size of array that right-left : left = 0 right = 3 ; size = 3
            for(int i=0;i<right-left;i++){

                // Updating every element after rotations
                // Storing the top left in one temp to empty the space for the next element to be enetered
                int topLeft = matrix[top][left + i];

                // Moving bottom left to top left
                matrix[top][left + i] = matrix[bottom - i][left];

                // Moving bottom right to bottom left
                matrix[bottom - i][left]  =matrix[bottom][right - i];

                // Moving top right to bottom right
                matrix[bottom][right - i] = matrix[top + i][right];

                // moving top left to top right
                matrix[top + i][right] = topLeft;

                // using i to move the pointer to their next/previous element for their rotation
            }
            right--;
            left++;
        }
    }
}
