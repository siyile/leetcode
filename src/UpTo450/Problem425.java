package UpTo450;

import java.util.ArrayList;
import java.util.List;

public class Problem425 {
    int len;
    Node root;

    private class Node {
        Node[] next;
        List<String> startsWith;
        Node() {
            next = new Node[26];
            startsWith = new ArrayList<>();
        }
    }

    private void addWord(Node root, String word, int i) {
        if (i == word.length()) {
            return;
        }
        if (root.next[word.charAt(i) - 'a'] == null) {
            root.next[word.charAt(i) - 'a'] = new Node();
        }
        Node next = root.next[word.charAt(i) - 'a'];

        next.startsWith.add(word);
        addWord(next, word, i + 1);
    }

    private List<String> find(Node node, StringBuilder sb) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            if (node.next[sb.charAt(i) - 'a'] == null) {
                return ans;
            } else {
                node = node.next[sb.charAt(i) - 'a'];
            }
        }
        return node.startsWith;
    }

    public List<List<String>> wordSquares(String[] words) {
        root = new Node();
        for (String word :
                words) {
            addWord(root, word, 0);
        }
        len = words[0].length();

        List<List<String>> ans = new ArrayList<>();

        List<String> wordList = new ArrayList<>();
        for (String word :
                words) {
            wordList.add(word);
            searchWord(1, wordList, ans);
            wordList.remove(wordList.size() - 1);
        }
        return ans;
    }

    private void searchWord(int i, List<String> wordList, List<List<String>> ans) {
        if (i == len) {
            ans.add(new ArrayList<>(wordList));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String word :
                wordList) {
            sb.append(word.charAt(i));
        }
        for (String word :
                find(root, sb)) {
            wordList.add(word);
            searchWord(i + 1, wordList, ans);
            wordList.remove(wordList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem425 p = new Problem425();

        System.out.println(p.wordSquares(new String[]{"area","lead","wall","lady","ball"}));
    }
}
