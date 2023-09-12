package tire;

//TrieNode => {TrieNode[] children, boolean isEndWord, int value,
//access root => getRoot()
//markAsLeaf(int val), unMarkAsLeaf()}
class NumWords {
    public static int num;
    public static int totalWords(TrieNode root){
        num =0;
        dfsNode(root);
        // Write - Your - Code
        return num;
    }

    private static void dfsNode(TrieNode root) {
        if(root == null || root.children.length == 0) return;
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i] == null) continue;
            TrieNode child = root.children[i];
            if(child.isEndWord) num++;
            dfsNode(child);
        }
    }
}
