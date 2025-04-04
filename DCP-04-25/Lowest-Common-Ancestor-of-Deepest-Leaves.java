
class Solution {
    /**
     * Finds the Lowest Common Ancestor (LCA) of the deepest leaves in a binary tree.
     * @param root The root node of the binary tree.
     * @return The LCA of the deepest leaves.
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;  // Base case: if tree is empty, return null

        int lh = height(root.left);  // Compute the height of the left subtree
        int rh = height(root.right); // Compute the height of the right subtree

        // If both subtrees have the same height, the current node is the LCA
        if (lh == rh) return root;

        // If left subtree is deeper, move towards left subtree
        if (lh > rh) 
            return lcaDeepestLeaves(root.left);
        
        // Otherwise, move towards right subtree
        return lcaDeepestLeaves(root.right);
    }

    /**
     * Calculates the height of a given binary tree.
     * @param root The root node of the tree.
     * @return The height of the tree.
     */
    private int height(TreeNode root) {
        if (root == null) return 0; // Base case: null node has height 0
        return 1 + Math.max(height(root.left), height(root.right)); // Compute height recursively
    }
}