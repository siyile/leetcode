import utils.TreeNode;

public class Problem979 {
    int amount;

    public int distributeCoins(TreeNode root) {
        acc(root);
        return amount;
    }

    private int acc(TreeNode node) {
        if (node == null) return 0;
        int coverage = acc(node.left) + acc(node.right);
        int move = node.val + coverage - 1;
        amount += Math.abs(move);
        return move;
    }
}
