class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);

        return (minLeft == 0 || minRight == 0)
                ? minLeft + minRight + 1
                : Math.min(minLeft, minRight) + 1;
    }
}
