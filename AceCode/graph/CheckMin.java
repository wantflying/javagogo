package graph;

class CheckMin {
    public static int findShortestPathLength(Graph g, int source, int destination) {
        //Write -- Your -- Code
        if(g.vertices <1) return -1;
        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);
        boolean[] isVisited = new boolean[g.vertices];
        int des = -1;
        int pathMinValue =Integer.MAX_VALUE;
        while (!stack.isEmpty()){
            Integer value = stack.pop();
            isVisited[value] =true;
            des++;
            if(value == destination){
                pathMinValue = Math.min(pathMinValue,des);
                isVisited[value] =false;
                des--;
            }else {
                DoublyLinkedList<Integer> linkedList = g.adjacencyList[value];
                if(linkedList == null || linkedList.isEmpty()){
                    des--;
                }else {
                    DoublyLinkedList<Integer>.Node tmpNode = linkedList.headNode;

                    while (tmpNode != null){
                        Integer data = tmpNode.data;
                        if(linkedList.size ==1 && isVisited[data]) des--;
                        if(!isVisited[data]){
                            stack.push(data);
                        }
                        tmpNode = tmpNode.nextNode;
                    }
                }
            }

        }
        if(pathMinValue == Integer.MAX_VALUE) return -1;
        return pathMinValue;
    }
    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,1);
        g.addEdge(2,4);
        g.addEdge(2,5);
        g.addEdge(3,1);
        g.addEdge(4,2);
        g.addEdge(4,5);
        g.addEdge(5,4);
        g.addEdge(5,2);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + findShortestPathLength(g,1,5));
        System.out.println();

    }

}