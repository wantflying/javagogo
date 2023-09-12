package graph;

class CheckNumEdges {
    public static int numEdges(Graph g) {
        // Write -- Your -- Code
        if(g.vertices <1 ) return -1;
        int num = 0;
        for (int i = 0; i < g.vertices; i++) {
            if(g.adjacencyList[i] == null || g.adjacencyList[i].headNode == null){
                continue;
            }else {
                DoublyLinkedList<Integer>.Node tmpNode = g.adjacencyList[i].headNode;
                while (tmpNode != null){
                    Integer data = tmpNode.data;
                    if(data>=i){
                        num ++;
                    }
                    tmpNode=tmpNode.nextNode;
                }
            }
        }
        return num;
    }
}