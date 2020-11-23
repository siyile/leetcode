# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def allPossibleFBT(self, N: int) -> List[TreeNode]:
        dp = [None for _ in range(N+1)]

        dp[1] = [TreeNode()]
        
        def bst(n):
            if dp[n]:
                return dp[n]
            
            ans = []
            for i in range(1, n-1):
                for left in bst(i):
                    for right in bst(n-1-i):
                        ans.append(TreeNode(0), left, right)
            dp[n] = ans
            return ans

        return bst(N)