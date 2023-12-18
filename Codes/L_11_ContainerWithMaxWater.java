package Codes;

public class L_11_ContainerWithMaxWater {
    // Time Complexity: O(n)
    // Greedy approach
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = Integer.MIN_VALUE;
        while(left < right){
            // calculating width of the container using given array index
            int width = right-left;
            // simply calulating the max area 
            int area = width * Math.min(height[left] , height[right]);
            max = Math.max(max , area);

            // increasing the pointers according to condition given
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
}
