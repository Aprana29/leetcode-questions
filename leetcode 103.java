

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag =new ArrayList<>();
        if(root==null) return zigzag;
        Queue<TreeNode> que =new LinkedList<>();
        que.add(root);
        boolean flag = false;
        while(!que.isEmpty()){
            int size= que.size();
            List<Integer> level =new ArrayList<>();
            Stack<Integer> st =new Stack<>();

            for(int i=0;i<size;i++){
                TreeNode node =que.poll();
                if(flag){
                    st.push(node.val);
                }
                else{
                    level.add(node.val);
                }
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            if(flag){
                while(!st.isEmpty()){
                    level.add(st.pop());

                }
            }
            zigzag.add(level);
            flag=!flag;
        }

        return zigzag;
    }
}