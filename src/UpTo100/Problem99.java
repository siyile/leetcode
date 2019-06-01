package UpTo100;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem99 {
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode first = null, second = null;
        TreeNode prev ;
         while (cur != null) {
            if (cur.left != null) {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right; // find prev node in left tree
                }
                if (prev.right == null) { // if prev.right == null
                    prev.right = cur;     // , put root to prev.right
                    cur = cur.left;       // root to left
                } else {
                    prev.right = null;            // restore tree shape
                    if(pre!=null && pre.val > cur.val){
                        if(first==null){first = pre;second = cur;}
                        else{second = cur;}
                    }
                    pre = cur;
                    cur = cur.right;              // go back to up node or move to right child
                }
            } else {
                if(pre!=null && pre.val > cur.val){
                    if(first==null){first = pre;second = cur;}
                    else{second = cur;}
                }
                pre = cur;
                cur = cur.right;
            }
        }
         int temp = first.val;
         first.val = second.val;
         second.val = temp;
    }

    public static void main(String[] args) {
        Problem99 p = new Problem99();
        int[] a = {1,3,0,0,2};
        BinaryTree t = new BinaryTree(a);
        p.recoverTree(t.root);
        BinaryTree.printNode(t.root);
    }
}
