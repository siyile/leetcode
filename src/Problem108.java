import utils.BinaryTree;
import utils.TreeNode;

public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length);
    }

    private TreeNode create(int[] nums, int start, int end) {
        if (end <= start) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums, start, mid);
        root.right = create(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Problem108 p = new Problem108();
        int[] a = {-10,-3,2,5,9};
        BinaryTree.printNode(p.sortedArrayToBST(a));
    }
}
