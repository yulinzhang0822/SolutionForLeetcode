class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }
        boolean control = true;//if true, from left; if false, from right
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for(int i=0; i<num; i++) {
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                if(tmpNode.left!=null) {
                    queue.offer(tmpNode.left);
                }
                if(tmpNode.right!=null) {
                    queue.offer(tmpNode.right);
                }
            }
            if(!control) {
                Collections.reverse(tmpList);
            }
            ans.add(tmpList);
            control = !control;
        }
        return ans;
    }
}
//Time:O(n), Space:O(n)
