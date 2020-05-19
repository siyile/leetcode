"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        ans = []
        stack = []

        if root != None:
            stack.append(root)
        
        while stack:
            node = stack.pop()
            ans.append(node.val)
            stack += [child for child in node.children if child]

        return reversed(ans)