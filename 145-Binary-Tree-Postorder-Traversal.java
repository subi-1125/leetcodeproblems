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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;     
    }
    private static void postorderTraversal(TreeNode root, List<Integer>result){
        if(root == null){
            return;
        }
        postorderTraversal(root.left,result);
        postorderTraversal(root.right,result);
        result.add(root.val);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;

        Solution solution = new Solution();
        List<Integer>postorderResult=solution.postorderTraversal(root);
        System.out.println(\post-order of the Binary Tree\);
        System.out.println(postorderResult);
    }
}