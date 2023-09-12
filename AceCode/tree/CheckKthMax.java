package tree;

class CheckKthMax {

    public static int findKthMax(Node root, int k) {
        int[] pathValue =  new int[k];
        for (int i = 0; i < pathValue.length; i++) {
            pathValue[i] = Integer.MAX_VALUE;
        }
        travele(root,pathValue);
        // Write - Your - Code
        return pathValue[pathValue.length-1] ;
    }

    private static void travele(Node tmp, int[] pathValue) {
        if(tmp == null) return;
        travele(tmp.getRightChild(),pathValue);
        if(pathValue[pathValue.length-1] != Integer.MAX_VALUE) return;
        for (int i = 0; i < pathValue.length; i++) {
            if(pathValue[i] ==Integer.MAX_VALUE) {
                pathValue[i] = tmp.getData();
                break;
            }
        }
        travele(tmp.getLeftChild(),pathValue);
    }
    public static void main(String args[]) {

        binarySearchTree bsT = new binarySearchTree();

        bsT.add(6);

        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);

        System.out.println(findKthMax(bsT.getRoot(),3));
    }
}