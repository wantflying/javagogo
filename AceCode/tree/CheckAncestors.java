package tree;

class CheckAncestors {
    public static String findAncestors(Node root, int k) {
        if(root == null || root.getData() == k) return "";
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(root.getData());
        Node tmpNode = root;
        while (tmpNode != null){
            int data = tmpNode.getData();
            if(data == k){
                return stringBuilder.toString();
            }else {
                    stringBuilder.append(data).append(",");
            }
            if(tmpNode.getData() < k){
                tmpNode = tmpNode.getRightChild();
            }else if(tmpNode.getData() > k){
                tmpNode = tmpNode.getLeftChild();
            }
        }
        return "";
    }


    // Driver code
    public static void main(String[] args)
    {
        binarySearchTree tree = new binarySearchTree();
		/* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14
		*/
        tree.add(6);
        tree.add(4);
        tree.add(9);
        tree.add(2);
        tree.add(5);
        tree.add(8);
        tree.add(8);
        tree.add(12);
        tree.add(10);
        tree.add(14);

        int key = 10;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));

        System.out.println();
        key = 5;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));
    }
}