# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def str2tree(self, s: str) -> TreeNode:
        if not s:
            return None
        node_s = []
        sign = 1
        base = 0
        for i, c in enumerate(s):
            if c == '(':
                continue
            elif c == ')':
                node_s.pop()
            else:
                if c == '-':
                    sign = -1
                    continue
                else:
                    if c.isdigit():
                        base *= 10
                        base += int(c)
                    if i + 1 == len(s) or not s[i + 1].isdigit():
                        cur = TreeNode(sign * base)
                        sign = 1
                        base = 0
                    else:
                        continue
                if node_s:
                    if node_s[-1].left:
                        node_s[-1].right = cur
                    else:
                        node_s[-1].left = cur
                node_s.append(cur)
        return node_s[0]
                    