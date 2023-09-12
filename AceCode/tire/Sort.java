package tire;

import java.util.ArrayList;

class Sort {

    public static ArrayList<String> sortArray(String[] arr) {
        ArrayList<String> result = new ArrayList<String>();
        Trie trie = new Trie();
        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }
        return TrieWords.findWords(trie.getRoot());
        // add your code here

    }
}