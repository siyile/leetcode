import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = post.length;
        for (int i = 0; i < n; i++) {
            map.put(post[i], i);
        }
        return build(pre, map, 0, 0, n);
    }

    private TreeNode build(int[] pre, Map<Integer, Integer> map, int s1, int s2, int N) {
        if (N == 0) return null;
        TreeNode node = new TreeNode(pre[s1]);
        if (N == 1) return node;
        int mi = map.get(pre[s1 + 1]);
        int n = mi - s2 + 1;
        node.left = build(pre, map, s1 + 1, s2, n);
        node.right = build(pre, map, s1 + 1 + n, mi + 1, N - n - 1);
        return node;
    }
}
