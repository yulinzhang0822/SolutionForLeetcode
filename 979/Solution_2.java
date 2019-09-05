//For each node, we use an int array to record the information [# of nodes in the subtree (include itself), # of total 
//coins in the subtree (include itself)]. Then we know that for a certain node, if there are more coins than nodes in the 
//subtree, the node must "contribute" the redundant coins to its parent. Else, if there are more nodes than coins in the 
//subtree, then the node must take some coins from the parent.

//Both of these two operations will create moves in the tree. And we just need to add the absolute value of the 
//(# nodes - # coins) to the final result because the move can be "contribute" or "take". The time complexity is O(n) 
//because we are just traversing the tree.

class Solution {
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        getNumAndCoins(root);
        return moves;
    }
    
    /*
     * return [number_of_nodes_in_subtree, number_of_total_coins_in_subtree]
     */
    private int[] getNumAndCoins(TreeNode node) {
        if (node == null) return new int[] {0, 0};
        int[] left = getNumAndCoins(node.left);
        int[] right = getNumAndCoins(node.right);
        moves += Math.abs(left[0] - left[1]) + Math.abs(right[0] - right[1]);
        return new int[] {left[0] + right[0] + 1, left[1] + right[1] + node.val};
    }
}
