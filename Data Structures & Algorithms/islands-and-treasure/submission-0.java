class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int land = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length
                        && grid[nx][ny] > grid[x][y]) {
                        grid[nx][ny] = grid[x][y] +1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        
    }
}
