package tree;

class CheckHeight {

    public static int currentHeight;
    public static int maxHeight;
    public static int findHeight(Node root) {
        if(root == null || (root.getLeftChild() == null && root.getRightChild() == null)) return 0;
        // Write - Your - Code

        dfsTree(root);

        return maxHeight-1;
    }

    private static void dfsTree(Node node) {
        currentHeight++;
        if(node == null) {
            currentHeight--;
            return;
        }
        maxHeight = Math.max(currentHeight,maxHeight);
        dfsTree(node.getLeftChild());
        dfsTree(node.getRightChild());
        currentHeight--;
    }

    public static void main(String args[]) {

        binarySearchTree bsT = new binarySearchTree();


        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);

        System.out.println(findHeight(bsT.getRoot()));

    }

}