package Codes;

import java.util.ArrayList;
import java.util.List;

public class L_501_FindModeInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
           }
    
       }
    int currNum = 0;
    int maxCount = 0;
    int maxFreq = 0;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        
        // way if changing list directly to an array form
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // Inoreder traversal is done in sorted tree array thus by doing this pointer is shifting and counting the occurences of repeated ones and putting them in list 
    public void inorderTraversal(TreeNode root){
        if(root == null){
            return; 
        }
        inorderTraversal(root.left);


        if(root.val == currNum){
            maxCount++;
        }else{
            currNum = root.val;
            maxCount = 1;
        }
        if(maxCount > maxFreq){
            list.clear();
            maxFreq = maxCount;
        }

        if(maxFreq == maxCount){
            list.add(root.val);
        }

        inorderTraversal(root.right);
    }

}


// Space Complexity: O(n)
  //    HashMap<Integer,Integer> map = new HashMap<>();
    //    dfs(map , root);
    //    int maxCount = 0;

    //    for(int nodeVal : map.keySet()){
    //        maxCount = Math.max(maxCount , map.get(nodeVal));
    //    }
    //    List<Integer> list = new ArrayList<>();
    //    for(int nodeVal : map.keySet()){
    //        if(map.get(nodeVal) == maxCount){
    //            list.add(nodeVal);
    //        }
    //    } 
    //    int[] res = new int[list.size()];
    //    for(int i=0;i<res.length;i++){
    //        res[i] = list.get(i);
    //    }

    //    return res;
    // }

    // public void dfs(HashMap<Integer,Integer> map , TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     map.put(root.val , map.getOrDefault(root.val , 0)+1);
    //     dfs(map , root.left);
    //     dfs(map , root.right);

