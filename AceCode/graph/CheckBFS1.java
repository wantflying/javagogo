package graph;

    class CheckBFS1 {

        //Breadth First Traversal of Graph g
        public static String bfs(Graph g) {
            String result = "";
            if(g.vertices<1) return  result;

            boolean[] isvisited = new boolean[g.vertices];

            for (int i = 0; i < isvisited.length; i++) {
                if(!isvisited[i]){
                    result += bfsNode(g,i,isvisited);
                }
            }



            return result;
        }

        private static String bfsNode(Graph g, int index, boolean[] isvisited) {
            String result = "";
            Queue<Integer> vistiRecord = new Queue<>(g.vertices);
            vistiRecord.enqueue(index);
            isvisited[index] = true;

            while (!vistiRecord.isEmpty()){
                int currentNode = vistiRecord.dequeue();
                result += currentNode;

                DoublyLinkedList<Integer>.Node tempNode = g.adjacencyList[currentNode].headNode;
                while (tempNode != null){
                    Integer data = tempNode.data;
                    if(isvisited[data] == false)
                    vistiRecord.enqueue(data);
                    isvisited[data] =true;
                    tempNode =tempNode.nextNode;
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
            System.out.println("BFS traversal of Graph1 : " + bfs(g));
            System.out.println();

            Graph g2 = new Graph(5);
            g2.addEdge(0,1);
            g2.addEdge(0,4);
            g2.addEdge(1,2);
            g2.addEdge(3,4);
            System.out.println("Graph2:");
            g2.printGraph();
            System.out.println("BFS traversal of Graph2 : " + bfs(g2));
        }

    }