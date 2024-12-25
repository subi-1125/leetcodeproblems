/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        List<Integer> largest = new ArrayList<>();

        while(!queue.isEmpty()) {
            int  len = queue.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0;i<len;i++){
                TreeNode currNode = queue.pollFirst();
                if(currNode.val > max) max = currNode.val;

                if(currNode.left != null) queue.addLast(currNode.left);
                if(currNode.right != null) queue.addLast(currNode.right); 
            }
            largest.add(max);
        }
        return largest;
        
    }
}