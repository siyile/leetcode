package UpTo600;

import java.util.*;

public class Problem588 {
    private class FileSystem {

        Node root;

        public FileSystem() {
            root = new Node("/");
        }

        public List<String> ls(String path) {
            Node node = extractPath(path);
            List<String> res = new ArrayList<>();
            if (node.isFile) {
                res.add(node.name);
            } else {
                res.addAll(node.children.keySet());
            }

            return res;
        }

        public void mkdir(String path) {
            extractPath(path);
        }

        public void addContentToFile(String filePath, String content) {
            Node node = extractPath(filePath);
            node.isFile = true;
            node.content.append(content);
        }

        public String readContentFromFile(String filePath) {
            Node node = extractPath(filePath);
            return node.content.toString();
        }

        private Node extractPath(String s) {
            String[] path = s.split("/");
            Node cur = root;
            for (int i = 1; i < path.length; i++) {
                String name = path[i];
                cur.children.computeIfAbsent(name, ignore -> new Node(name));
                cur = cur.children.get(name);
            }

            return cur;
        }

        private class Node {
            boolean isFile;
            Map<String, Node> children;
            String name;
            StringBuilder content;

            public Node(String name) {
                this.name = name;
                children = new TreeMap<>();
                content = new StringBuilder();
            }
        }
    }
}