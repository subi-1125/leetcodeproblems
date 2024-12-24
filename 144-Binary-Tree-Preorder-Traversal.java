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
    public List<Integer>preorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        preorderTraversal(root,result);
        return result;
    }
    private static void preorderTraversal(TreeNode root, List<Integer>result){
        if(root == null){
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right,result);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left=null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = null;
         Solution solution = new Solution();
         List<Integer>preorderResult = solution.preorderTraversal(root);
         System.out.println(\pre-order traversal of the Binary tree\);
         System.out.println(preorderResult);
    }
        
    }
