import utils.BinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        path(root, sum, ans, new ArrayList<>());
        return ans;
    }

    public void path(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> temp) {
        if (root == null) return ;
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                temp.add(root.val);
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            } else return;
        }
        temp.add(root.val);
        path(root.left, sum - root.val, ans, temp);
        path(root.right, sum - root.val, ans, temp);
        temp.remove(temp.size() - 1);
    }



    public static void main(String[] args) {
        Problem113 p = new Problem113();
        int[] a = {5,4,8,11,0,13,4,7,2,0,0,5,1};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.pathSum(t.root, 22));
    }
}
