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
class FindElements {

    TreeNode base;

    public FindElements(TreeNode root) {
        base = root;
    }
    
    public boolean find(int target) {
        String mask = Integer.toBinaryString(target+1);
        TreeNode temp = base;
        for(int i = 1;i<mask.length();i++){
            if(mask.charAt(i) == '1'){
                if(temp.right == null){
                    return false;
                }
                temp = temp.right;
            }
            else{
                if(temp.left == null){
                    return false;
                }
                temp = temp.left;
            }
        }
        return true;
        
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */