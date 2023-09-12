package tree;

class CheckMin
{
    public static int findMin(Node root)
    {
        if(root == null) return Integer.MIN_VALUE;
        Node tmpNode = root;
        while (tmpNode.getLeftChild() != null){
            tmpNode = tmpNode.getLeftChild();
        }
        return tmpNode.getData();
        // Write - Your - Code

    }
}