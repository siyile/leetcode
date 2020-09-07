# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: TreeNode, v: int, d: int) -> TreeNode:
        def helper(node, d):
            if node == None:
                return
            if d == 1:
                n = TreeNode(v)
                n.left = node.left
                node.left = n
                n = TreeNode(v)
                n.right = node.right
                node.right = n
                return
            helper(node.left, d - 1)
            helper(node.right, d - 1)

        if d == 1:
            node = TreeNode(v)
            node.left = root
            return node
        
        helper(root, d - 1)

        return root
        