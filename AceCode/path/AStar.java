package path;

import java.util.*;

class AStarNode {
    public AStarNode parent;
    int x, y; // 节点的坐标
    int g;    // 从起始点到该节点的实际代价
    int h;    // 从该节点到目标节点的估计代价

    public AStarNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getF() {
        return g + h;
    }
}

public class AStar {
    private int[][] grid; // 二维地图，0表示可通过，1表示障碍物
    private int width;    // 地图宽度
    private int height;   // 地图高度

    public AStar(int[][] grid) {
        this.grid = grid;
        this.width = grid.length;
        this.height = grid[0].length;
    }

    public List<AStarNode> findPath(int startX, int startY, int targetX, int targetY) {
        PriorityQueue<AStarNode> openSet = new PriorityQueue<>(Comparator.comparingInt(AStarNode::getF));
        Set<AStarNode> closedSet = new HashSet<>();

        AStarNode startNode = new AStarNode(startX, startY);
        startNode.g = 0;
        startNode.h = heuristic(startX, startY, targetX, targetY);

        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            AStarNode current = openSet.poll();

            if (current.x == targetX && current.y == targetY) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            for (AStarNode neighbor : getNeighbors(current)) {
                if (closedSet.contains(neighbor)) {
                    continue;
                }

                int tentativeG = current.g + 1; // 1是移动到相邻节点的代价

                if (!openSet.contains(neighbor) || tentativeG < neighbor.g) {
                    neighbor.g = tentativeG;
                    neighbor.h = heuristic(neighbor.x, neighbor.y, targetX, targetY);
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return null; // 无法找到路径
    }

    private int heuristic(int x1, int y1, int x2, int y2) {
        // 曼哈顿距离作为启发式函数
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private List<AStarNode> getNeighbors(AStarNode node) {
        List<AStarNode> neighbors = new ArrayList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];

            if (nx >= 0 && nx < width && ny >= 0 && ny < height && grid[nx][ny] == 0) {
                neighbors.add(new AStarNode(nx, ny));
            }
        }

        return neighbors;
    }

    private List<AStarNode> reconstructPath(AStarNode node) {
        List<AStarNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0}
        };

        AStar aStar = new AStar(grid);
        List<AStarNode> path = aStar.findPath(0, 0, 4, 4);

        if (path != null) {
            for (AStarNode node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")");
            }
        } else {
            System.out.println("无法找到路径");
        }
    }
}
