class Solution {
    boolean[][] visited;
    int[][] dirs ={{0,1}, {0,-1}, {1,0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        boolean res = false; 
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j]= true;
                    res=  helper(board,visited, i,j, word, 1);
                    if(res) return res;
                    visited[i][j]= false;
                }
            }
        }
        return res;
    }
    public boolean helper(char[][] board, boolean[][] visited, int row, int col, String word, int index){
        if(index == word.length()){ 
            return true;
        }
        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr>=0 && nr<board.length && nc>=0 && nc< board[0].length && !visited[nr][nc] && word.charAt(index)== board[nr][nc]){
                visited[nr][nc] = true;
                if(helper(board, visited, nr, nc, word, index+1))
                    return true;
                visited[nr][nc] = false;
            }
        }
        return false;
    }
}