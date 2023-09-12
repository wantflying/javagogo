package graph;

class CheckCycle {
    public static boolean detectCycle(Graph g){
        // Write -- Your -- Code
        if(g.vertices <  1) return  false;
        Boolean[] isVisited = new Boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
             if(dfsNode(g,i,isVisited) ) return  true;
        }

        return false;
    }

    private static Boolean dfsNode(Graph g, int source, Boolean[] isVisited) {
        Boolean[] isChecked = new Boolean[g.vertices];
        for (int i = 0; i < isChecked.length; i++) {
            isChecked[i] = false;
        }
        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);
        while (!stack.isEmpty()){
            int value = stack.pop();
            if(isChecked[value]){
                return true;
            }
            isChecked[value] =true;
            isVisited[value] = true;

            DoublyLinkedList<Integer> doublyLinkedList = g.adjacencyList[value];
            if(doublyLinkedList == null || doublyLinkedList.headNode == null){
                return false;
            }
            DoublyLinkedList<Integer>.Node tmpNode = doublyLinkedList.headNode;
            while (tmpNode != null){
                Integer tmpdata = tmpNode.data;
                if(isChecked[tmpdata]) return true;
                stack.push(tmpdata);
                tmpNode = tmpNode.nextNode;
            }


        }
        return false;
    }



    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + detectCycle(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + detectCycle(g2));
    }
}