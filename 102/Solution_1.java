//Two queues
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.offer(root);
        level.offer(1);
        int curLevel = 1;
        List<Integer> tmpList = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode tmpNode = queue.poll();
            int tmpLevel = level.poll();
            if(tmpLevel>curLevel) {
                ans.add(tmpList);
                tmpList = new ArrayList<>();
                curLevel = tmpLevel;
            }
            tmpList.add(tmpNode.val);
            if(tmpNode.left!=null) {
                queue.offer(tmpNode.left);
                level.offer(tmpLevel+1);
            }
            if(tmpNode.right!=null) {
                queue.offer(tmpNode.right);
                level.offer(tmpLevel+1);
            }
        }
        if(tmpList.size()>0) {
            ans.add(tmpList);
        }
        return ans;
    }
}
//Time:O(k),Space:O(k),k is the number of nodes
