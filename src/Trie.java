public class Trie {
    Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int currentChar = word.charAt(i) - 'a';
            if (node.children[currentChar] == null) {
                node.children[currentChar] = new Node();
            }
            node = node.children[currentChar];
        }
        node.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node == null)
                return false;
            node = node.children[word.charAt(i) - 'a'];
        }
        return node != null && node.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node == null)
                return false;
            node = node.children[prefix.charAt(i) - 'a'];
        }
        return node != null;
    }

    class Node {
        Node[] children;
        boolean end;

        public Node() {
            children = new Node[26];
            end = false;
        }
    }
}