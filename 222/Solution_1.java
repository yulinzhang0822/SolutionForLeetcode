class Solution {
    public int countNodes(TreeNode root) {
        int ans = 0;
        if(root==null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            ans++;
            if(tmpNode.left!=null) {
                queue.offer(tmpNode.left);
            }
            if(tmpNode.right!=null) {
                queue.offer(tmpNode.right);
            }
        }
        return ans;
    }
}
//Time:O(N), Space:O(N)
