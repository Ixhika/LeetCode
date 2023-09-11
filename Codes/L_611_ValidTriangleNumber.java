package Codes;

import java.util.Arrays;

public class L_611_ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        // a,b,c
        // a+b>c where a,b,c is sorted
        int n = nums.length;
        int count = 0;

        // fix position of c and try to find a,b that satisfy a+b
        // c+a>b , c+b>a are satisfied by default when c is largest
        for(int i=n-1;i>=2;i--){
            int j =i-1;
            int k=0;
        // [2,2,3,4] i = 4; j= 3 k=2 
            while(k<j){
                if(nums[k]+nums[j] > nums[i]){
                    count = count+ j-k;
                    j--;
                }else{
                    k++;
                }
            }
        }
        return count;
    }
}



// Time Limit Exceeded (Basic brute force approach O(n^3))
// for(int i=0;i<n-2;i++){
//   for(int j=i+1;j<n-1;j++){
//      for(int k=j+1;k<n;k++){
//        if(nums[i] + nums[j] > nums[k] && 
//           nums[i]+nums[k] > nums[j] && nums[j]+nums[k] > nums[i]){
//               count++;   
//        }
//    }
//}
//return count;