# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTilt(self, root: TreeNode) -> int:
        return self.helper(root)[1]

    def helper(self, root):
        if root == None:
            return (0, 0)
        left = helper(root.left)
        right = helper(root.right)
        return left[1] + right[1] + abs(left[2] - right[2]), left[2] + right[2] + root.val