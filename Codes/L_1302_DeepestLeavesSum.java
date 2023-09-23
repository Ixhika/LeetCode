import java.util.LinkedList;
import java.util.Queue;

public class L_1302_DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return root.val;
        }
        // Initializing a sum that will calulate values at each level
       int sum = 0;
    //    Creating a queue where one by one elements with their neighbours will be added: Basically using bfs.
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       while(!queue.isEmpty()){
        
        // Making value of sum=0 as after each level the sum becomes zero and then for next level sum begins from 0. 
        // Thus by doing this at last only the sum of last level /deepest leave will be stored and it will return the required the resultant

           sum = 0;
           int len = queue.size();
            for(int i=0;i<len;i++){
                TreeNode newNode = queue.poll();
                sum += newNode.val;

                if(newNode.left != null){
                    queue.offer(newNode.left);
                }
                if(newNode.right != null){
                    queue.offer(newNode.right);
                
                }
            }
       }
       return sum;
    }
}
