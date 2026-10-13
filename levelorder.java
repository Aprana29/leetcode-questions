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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result =new ArrayList<>();
        Queue<Integer> qu=new LinkedList<>();

        qu.add(root.val);
        while(!qu.isEmpty()){
            int n=qu.size();
            List<Integer> a=new ArrayList<>();

            for(int i=0;i<n;i++){
                int curr= qu.poll();
                a.add(curr);
                if(curr.left!=null){
                    qu.add(curr.left.val);
                }
                if(curr.right!=null)
                {
                    qu.add(curr.right.val);
                }
            }
            result.add(a);
        }

    }
}
