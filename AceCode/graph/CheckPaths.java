package graph;

class CheckPaths {

    public static boolean checkPath(Graph g, int source, int destination) {
        // Write - Your - Code
        if(g.vertices <1) return false;


        boolean isExist = dfsNode(g,source,destination);


        return false;
    }

    private static boolean dfsNode(Graph g, int source, int destination) {

        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);

        while (!stack.isEmpty()){
            Integer value = stack.pop();
            if(value == destination) return true;
            DoublyLinkedList<Integer> linkedList = g.adjacencyList[value];
            if(!linkedList.isEmpty() && linkedList.headNode != null){
                DoublyLinkedList<Integer>.Node tmpNode = linkedList.headNode;
                while (tmpNode != null){
                    stack.push(tmpNode.data);
                    tmpNode = tmpNode.nextNode;
                }
            }
        }

        return false;
    }


}