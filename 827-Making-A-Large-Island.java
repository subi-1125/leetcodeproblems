class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int index = 2; 
        Map<Integer, Integer> islandSize = new HashMap<>();
        boolean hasZero = false;
        int maxIsland = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, index);
                    islandSize.put(index, size);
                    maxIsland = Math.max(maxIsland, size);
                    index++;
                } else {
                    hasZero = true;
                }
            }
        }

        if (!hasZero) return maxIsland;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenIslands = new HashSet<>();
                    int newSize = 1; 
                    for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            int islandIndex = grid[ni][nj];
                            if (seenIslands.add(islandIndex)) { 
                                newSize += islandSize.get(islandIndex);
                            }
                        }
                    }

                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland;
    }
    private int dfs(int[][] grid, int i, int j, int index) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) return 0;

        grid[i][j] = index; 
        int size = 1;

        for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            size += dfs(grid, i + dir[0], j + dir[1], index);
        }

        return size;
    }
}