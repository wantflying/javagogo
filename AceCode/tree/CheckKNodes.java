package tree;

class CheckKNodes {

    public static int currentLength;
    public static String result;
    public static String findKNodes(Node root, int k) {
        if(root == null || k==0) return "";
        currentLength = 0;
        result ="";
        dfsNode(root,k);
        //Write Your Code Here
        return result;
    }

    private static void dfsNode(Node root, int k) {
        currentLength++;
        if(root == null){
            currentLength--;
            return;
        }
        if(currentLength-1 == k){
            result += root.getData()+",";
            currentLength--;
            return;
        }
        dfsNode(root.getLeftChild(),k);
        dfsNode(root.getRightChild(),k);
        currentLength--;
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

        System.out.println(findKNodes(bsT.getRoot(),2));

    }
}