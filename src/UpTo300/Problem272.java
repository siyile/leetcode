package UpTo300;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<TreeNode> predS = new ArrayDeque<>();
        Deque<TreeNode> succS = new ArrayDeque<>();
        getStack(predS, true, target, root);
        getStack(succS, false, target, root);

        if (!predS.isEmpty() && !succS.isEmpty() && predS.peek().val == succS.peek().val) {
            getNext(predS, true);
        }

        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
            if (predS.isEmpty()) {
                res.add(succS.peek().val);
                getNext(succS, false);
            } else if (succS.isEmpty()) {
                res.add(predS.peek().val);
                getNext(predS, true);
            } else {
                if (Math.abs(target - predS.peek().val) > Math.abs(target - succS.peek().val)) {
                    res.add(succS.peek().val);
                    getNext(succS, false);
                } else {
                    res.add(predS.peek().val);
                    getNext(predS, true);
                }
            }
        }
        return res;
    }

    private void getStack(Deque<TreeNode> stack, boolean isPred, double target, TreeNode node) {
        while (node != null) {
            if (node.val == target) {
                stack.push(node);
                return;
            } else if (node.val > target) {
                if (!isPred) {
                    stack.push(node);
                }
                node = node.left;
            } else {
                if (isPred) {
                    stack.push(node);
                }
                node = node.right;
            }
        }
    }

    private void getNext(Deque<TreeNode> stack, boolean isPred) {
        TreeNode node = stack.pop();
        node = isPred ? node.left : node.right;
        while (node != null) {
            stack.push(node);
            node = !isPred ? node.left : node.right;
        }
    }
}
