import utils.TreeNode;

public class Problem889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return build(pre, post, 0, 0, pre.length);
    }

    public TreeNode build(int[] pre, int[] post, int l1, int l2, int n) {
        if (n == 0) return null;
        if (n == 1) return new TreeNode(pre[l1]);
        int i = 0;
        for (; i < n; i++) {
            if (post[i + l2] == pre[l1 + 1])
                break;
        }
        TreeNode node = new TreeNode(pre[l1]);
        node.left = build(pre, post, l1 + 1, l2, i + 1);
        node.right = build(pre, post, l1 + i + 1, l2 + i, n - i - 2);
        return node;
    }
}
