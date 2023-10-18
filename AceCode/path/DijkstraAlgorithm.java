//package path;
//
//import java.util.*;
//
//class Graph {
//    private int V;  //图中顶点的数量
//    private ListListNode adjacencyList;  //邻接表表示图的连接关系
//
//    public Graph(int V) {
//        this.V = V;
//        adjacencyList = new ArrayList(V);
//
//        for (int i = 0; i  V; i++) {
//            adjacencyList.add(new ArrayList());
//        }
//    }
//
//     添加有向边
//    public void addEdge(int source, int destination, int weight) {
//        Node node = new Node(destination, weight);
//        adjacencyList.get(source).add(node);
//    }
//
//     Dijkstra算法的实现
//    public int[] dijkstra(int startVertex) {
//        int[] distance = new int[V];
//        Arrays.fill(distance, Integer.MAX_VALUE);
//        distance[startVertex] = 0;
//
//        PriorityQueueNode priorityQueue = new PriorityQueue(Comparator.comparingInt(node - node.weight));
//        priorityQueue.add(new Node(startVertex, 0));
//
//        while (!priorityQueue.isEmpty()) {
//            int currentVertex = priorityQueue.poll().vertex;
//
//            for (Node neighbor  adjacencyList.get(currentVertex)) {
//                int newDistance = distance[currentVertex] + neighbor.weight;
//
//                if (newDistance  distance[neighbor.vertex]) {
//                    distance[neighbor.vertex] = newDistance;
//                    priorityQueue.add(new Node(neighbor.vertex, newDistance));
//                }
//            }
//        }
//
//        return distance;
//    }
//
//    static class Node {
//        int vertex;
//        int weight;
//
//        public Node(int vertex, int weight) {
//            this.vertex = vertex;
//            this.weight = weight;
//        }
//    }
//}
//
//public class DijkstraAlgorithm {
//    public static void main(String[] args) {
//        int V = 5;
//        int startVertex = 0;
//
//        Graph graph = new Graph(V);
//        graph.addEdge(0, 1, 2);
//        graph.addEdge(0, 3, 1);
//        graph.addEdge(1, 2, 3);
//        graph.addEdge(1, 3, 2);
//        graph.addEdge(3, 4, 4);
//        graph.addEdge(2, 4, 1);
//
//        int[] shortestDistances = graph.dijkstra(startVertex);
//
//        System.out.println(最短路径从顶点  + startVertex +  开始);
//        for (int i = 0; i  V; i++) {
//            System.out.println(到顶点  + i +  的最短距离是  + shortestDistances[i]);
//        }
//    }
//}
