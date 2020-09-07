# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxSumBST(self, root: TreeNode) -> int:
        self.ans = 0
        def dfs(node):
            if node == None:
                return [float('-inf'), float('inf'), 0]

            left = dfs(node.left)
            right = dfs(node.right)

            cur = 0

            if node.left and node.val <= left[1] or node.right and node.val >= right[0]:
                return [0, 0, float('-inf')]

            cur = cur + left[2] + right[2]
            
            self.ans = max(self.ans, cur)

            return [min(left[0], node.val), max(right[1], node.val), cur]
        
        dfs(root)
        return self.ans
