# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def tree2str(self, t: TreeNode) -> str:
        if t == None:
            return ''
        s = str(t.val)
        if t.left != None:
            s += '(' + self.tree2str(t.left) + ')'
        elif t.right != None:
            s += '()'
        if t.right != None:
            s += '(' + self.tree2str(t.right) + ')'
        return s
        