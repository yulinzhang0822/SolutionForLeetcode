class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if(root==null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> pos = new LinkedList<>();
        queue.offer(root);
        pos.offer(1);
        while(!queue.isEmpty()) {
            int num = queue.size();
            int leftmost = -1, rightmost = -1;
            for(int i=0; i<num; i++) {
                TreeNode tmpNode = queue.poll();
                int tmpPos = pos.poll();
                if(i==0) {
                    leftmost = tmpPos;
                }
                if(i==num-1) {
                    rightmost = tmpPos;
                }
                if(tmpNode.left!=null) {
                    queue.offer(tmpNode.left);
                    pos.offer(tmpPos*2);
                }
                if(tmpNode.right!=null) {
                    queue.offer(tmpNode.right);
                    pos.offer(tmpPos*2+1);
                }
            }
            ans = Math.max(ans,rightmost-leftmost+1);
        }
        return ans;
    }
}
//Time:O(n), Space:O(n)
