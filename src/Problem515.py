# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        ans = []

        def preorder(root, d):
            if root == None:
                return
            if len(ans) == d:
                ans.append(root.val)
            else:
                if ans[d] < root.val:
                    ans[d] = root.val
            preorder(root.left, d + 1)
            preorder(root.right, d + 1)

        preorder(root, 0)
        return ans