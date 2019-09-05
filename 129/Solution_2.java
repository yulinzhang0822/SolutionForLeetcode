//Iterative
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> nodePath = new Stack<>();
        nodeStack.push(root);
        nodePath.push(""+root.val);
        int runningSum = 0;
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            String currentPath = nodePath.pop();
            if(node.left != null){
                nodeStack.push(node.left);
                nodePath.push(currentPath+ (""+ node.left.val) );
            }
            if(node.right != null){
                nodeStack.push(node.right);
                nodePath.push(currentPath + (""+node.right.val));
            }
            if( node.left == null && node.right == null){
                runningSum = runningSum + Integer.valueOf(currentPath);
            }
        }
        return runningSum;
    }
}
