1.Start traversing the tree from the root node.
2.If the current node itself is one of p or q, we would mark a variable mid as True and continue the search for the 
  other node in the left and right branches.
3.If either of the left or the right branch returns True, this means one of the two nodes was found below.
4.If at any point in the traversal, any two of the three flags left, right or mid become True, this means we have found 
  the lowest common ancestor for the nodes p and q.
class Solution {

    private TreeNode ans;

    public Solution() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
//Time:O(N),Time:O(N)
