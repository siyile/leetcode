# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findFrequentTreeSum(self, root: TreeNode) -> List[int]:
        if root == None:
            return []
        cnt = {}
        ans = set()
        max_cnt = None

        def postOrder(root: TreeNode) -> int:
            if root == None:
                return 0
            curr_sum = postOrder(root.left) + postOrder(root.right) + root.val
            if max_cnt == None:
                cnt[curr_sum] = cnt.get(curr_sum, 0) + 1
            if max_cnt == cnt[curr_sum]:
                ans.add(curr_sum)
            return curr_sum
        
        postOrder(root)
        max_cnt = max(cnt.values())
        postOrder(root)

        return list(ans)
        
        
    
    