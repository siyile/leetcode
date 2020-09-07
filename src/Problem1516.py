"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children if children is not None else []
"""

class Solution:
    def moveSubTree(self, root: 'Node', p: 'Node', q: 'Node') -> 'Node':
        def getParent(node, p):
            for child in node.children:
                if child.val == p.val:
                    return node
                parent = getParent(child, p)
                if parent:
                    return parent
            return None
        
        def delete(root, target, replace=None):
            if root != None:
                for i in range(len(root.children)):
                    if root.children[i].val == target.val:
                        if replace:
                            root.children[i] = replace
                        else:
                            root.children.pop(i)
                        break

        parentP = getParent(root, p)
        if not parentP or parentP.val != q.val:
            parentQinP = getParent(p, q)
            if parentQinP != None:
                delete(parentQinP, q)
            delete(parentP, p, q if parentQinP else None)
            q.children.append(p)
        return q if root.val == p.val else root

            
            

