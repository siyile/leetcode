"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        ans = []
        stack = []
        if root != None:
            stack.append(root)
        
        while stack:
            node = stack.pop()
            ans.append(node.val)
            for i in range(len(node.children) - 1, 0, -1):
                stack.append(node.children[i])
            while node.children:
                node = node.children[0]
                ans.append(node.val)
                for i in range(len(node.children) - 1, 0, -1):
                    stack.append(node.children[i])

        return ans
        