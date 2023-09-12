package graph;

class RemoveEdgeChallenge {
    public static void removeEdge(Graph g, int source, int destination) {
        //Write -- Your -- Code
        if(g.vertices <1 || source== destination) return;

        DoublyLinkedList<Integer> list = g.adjacencyList[source];
        if(list == null || list.isEmpty()) return;

        DoublyLinkedList<Integer>.Node tmpNode = list.headNode;
        while (tmpNode != null){
            Integer data = tmpNode.data;
            if(data == destination){
                if(tmpNode.prevNode == null){
                    tmpNode = tmpNode.nextNode;
                    list.headNode = tmpNode;

                }else {
                   tmpNode.prevNode.nextNode=tmpNode.nextNode;
                }
                break;
            }else {
                tmpNode =tmpNode.nextNode;
            }
        }
    }
}