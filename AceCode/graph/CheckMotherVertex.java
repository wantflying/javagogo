package graph;

class CheckMotherVertex {

    public static int findMotherVertex(Graph g){
        // Write - Your - Code
        if(g.vertices<1) return -1;
        boolean[] isVisited = new boolean[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            int visitNum = dfsNode(g,i,isVisited);
            if(visitNum == g.vertices) return i;
        }

        return -1;
    }

    private static int dfsNode(Graph g, int source, boolean[] isVisited) {
        int num =0;
        isVisited = new boolean[g.vertices];
        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);

        while (!stack.isEmpty()){
            Integer value = stack.pop();
            isVisited[value] = true;
            num++;
            DoublyLinkedList<Integer> doublyLinkedList = g.adjacencyList[value];
            if(doublyLinkedList == null || doublyLinkedList.isEmpty()){
                continue;
            }
            DoublyLinkedList<Integer>.Node tmpNode = doublyLinkedList.headNode;
            while (tmpNode != null){
                if(!isVisited[tmpNode.data]){
                    stack.push(tmpNode.data);
                }
                tmpNode = tmpNode.nextNode;
            }
        }
        return num;
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + findMotherVertex(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + findMotherVertex(g2));
    }
}