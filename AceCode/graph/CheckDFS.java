package graph;

class CheckDFS {
    //Depth First Traversal of Graph g
    public static String dfs(Graph g) {
        String result = "";
        if(g.vertices <1) return  result;

        boolean[] isVisited = new boolean[g.vertices];
        for (int i = 0; i < g.vertices; i++) {
            if(isVisited[i] == false){
                result += dfsNode(g.adjacencyList,i,isVisited);
            }
        }
        // Write - Your - Code
        return result;
    }

    private static String dfsNode(DoublyLinkedList<Integer>[] garray,int source,boolean[] isVIsited) {
//        if(isVIsited[source] == true) return "";

        DoublyLinkedList<Integer> list = garray[source];
        String result = "";
        if(list.isEmpty()){
            isVIsited[source] = true;
            return String.valueOf(source);
        }else {
            isVIsited[source] = true;
            result += String.valueOf(source);
        }

        DoublyLinkedList<Integer>.Node tmpNode = list.headNode;
        while (tmpNode != null){
            Integer data = tmpNode.data;
            if(isVIsited[data] == true){
                tmpNode = tmpNode.nextNode;
            }else {
//                isVIsited[data] =true;
//                result += String.valueOf(data);
                result +=dfsNode(garray,data,isVIsited);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + dfs(g2));
    }
}