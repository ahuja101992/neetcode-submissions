class Solution {
    int[][] dirs ={{0,1}, {0,-1}, {1,0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        boolean res = false; 
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)) {
                    char temp = board[i][j];
                    board[i][j] = '#';
                    res=  helper(board, i,j, word, 1);
                    if(res) return res;
                    board[i][j] = temp;
                }
            }
        }
        return res;
    }
    public boolean helper(char[][] board, int row, int col, String word, int index){
        if(index == word.length()){ 
            return true;
        }
        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr>=0 && nr<board.length && nc>=0 && nc< board[0].length && word.charAt(index)== board[nr][nc]){
                char temp = board[nr][nc];
                board[nr][nc]= '#';
                if(helper(board, nr, nc, word, index+1))
                    return true;
                board[nr][nc]= temp;
            }
        }
        return false;
    }
}