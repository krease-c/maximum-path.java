class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Solution {
    
    private int maxSum = Integer.MIN_VALUE; // Global variable to track the maximum path sum
    
    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxSum;
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the maximum path sum for the left and right subtrees
        // We take 0 if the sum is negative (i.e., we ignore paths that decrease the sum)
        int leftMax = Math.max(calculateMaxPathSum(node.left), 0);
        int rightMax = Math.max(calculateMaxPathSum(node.right), 0);

        // Calculate the price of the current path (the sum of the current node's value
        // and the maximum paths from the left and right subtrees)
        int currentPathSum = node.val + leftMax + rightMax;

        // Update the global maximum sum if the current path sum is larger
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum sum of the path that can be extended to the parent
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree:
        //      -10
        //     /   \
        //    9     20
        //         /  \
        //        15   7
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        int maxPathSum = solution.maxPathSum(root);

        // Output the maximum path sum
        System.out.println("Maximum path sum: " + maxPathSum); // Expected output: 42
    }
}

