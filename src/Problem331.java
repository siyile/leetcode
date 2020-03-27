public class Problem331 {
    int i = 0;
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        return verify(nodes) && i == nodes.length;
    }

    private boolean verify(String[] nodes) {
        if (i >= nodes.length) return false;
        if (nodes[i].charAt(0) == '#') {
            i += 1;
            return true;
        } else {
            i += 1;
            return verify(nodes) && verify(nodes);
        }
    }
}
