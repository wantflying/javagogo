package tire;

import java.util.ArrayList;
import java.util.Arrays;

//TrieNode => {TrieNode[] children, boolean isEndWord, int value,
//markAsLeaf(int val), unMarkAsLeaf()}
class TrieWords
{
    //Recursive Function to generate all words
    public static void getWords(TrieNode root, ArrayList < String > result, int level, char[] str)
    {
        // use this as helper function
        if(root == null || root.children.length ==0) return;
        TrieNode[] children = root.children;
        for (int i = 0; i < children.length; i++) {
            if(children[i] != null){
                str[level] = (char) (i+'a');
                if(children[i].isEndWord){
                    String substring ="";
                    for (int i1 = 0; i1 < level+1; i1++) {
                        substring += str[i1];
                    }
                    result.add(substring);
                }
                getWords(children[i],result,++level,str);
                level--;
            }
        }

    }
    public static ArrayList< String > findWords(TrieNode root)
    {
        if(root == null || root.children.length ==0) return new ArrayList < String > ();
        ArrayList < String > result = new ArrayList < String > ();
        char[] str = new char[20];
        getWords(root,result,0,str);
        // write your code here
        return result;
    }


    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList < String > list = findWords(t.getRoot());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}