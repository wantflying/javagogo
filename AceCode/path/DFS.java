package path;

import java.util.*;

// 深度优先搜索 DFS
class MazeDFS {
    private int numRows; // 迷宫的行数
    private int numCols; // 迷宫的列数
    private int[][] maze; // 迷宫地图
    private boolean[][] visited; // 记录已访问的位置
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右四个方向

    public MazeDFS(int[][] maze) {
        this.maze = maze;
        this.numRows = maze.length;
        this.numCols = maze[0].length;
        this.visited = new boolean[numRows][numCols];
    }

    public List<int[]> findPath(int[] start, int[] end) {
        List<int[]> path = new ArrayList<>();
        dfs(start[0], start[1], end[0], end[1], path);
        return path;
    }

    private boolean dfs(int x, int y, int targetX, int targetY, List<int[]> path) {
        if (x < 0 || x >= numRows || y < 0 || y >= numCols || maze[x][y] == 1 || visited[x][y]) {
            return false; // 越界、墙壁或已访问的位置，返回失败
        }

        visited[x][y] = true;
        path.add(new int[]{x, y});

        if (x == targetX && y == targetY) {
            return true; // 到达目标点，返回成功
        }

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (dfs(newX, newY, targetX, targetY, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1); // 回溯
        return false;
    }
}

public class DFS {
    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
        };

        MazeDFS mazeDFS = new MazeDFS(maze);
        int[] start = {0, 0};
        int[] end = {4, 4};

        List<int[]> path = mazeDFS.findPath(start, end);

        if (path != null) {
            System.out.println("找到路径:");
            for (int[] point : path) {
                System.out.println("(" + point[0] + ", " + point[1] + ")");
            }
        } else {
            System.out.println("未找到路径");
        }
    }
}
