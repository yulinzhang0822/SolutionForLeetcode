class Solution {
    public int countBattleships(char[][] board) {
        int cur=0;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='X'){
                    if (i>0 && board[i-1][j]=='X'){
                        continue;
                    }
                    else if (j>0 && board[i][j-1]=='X'){
                        continue;
                    }
                    cur ++;
                }
            }
        }
        return cur;
    }
}
//Time:O(N^2), Space:O(1)
