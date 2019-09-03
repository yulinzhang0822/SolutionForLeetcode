//Recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        postOrder(root, res);
        return res;
    }
    
    private void postOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.val);  
    }
}
