class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight

class Solution:
    def intersect(self, quadTree1: 'Node', quadTree2: 'Node') -> 'Node':
        if quadTree1.isLeaf and quadTree2.isLeaf:
            quadTree1.val = quadTree1.val | quadTree2.val
            return quadTree1
        elif quadTree1.isLeaf and not quadTree2.isLeaf:
            if quadTree1.val == 1:
                return quadTree1
            else:
                return quadTree2
        elif not quadTree1.isLeaf and quadTree2.isLeaf:
            if quadTree2.val == 1:
                return quadTree2
            else:
                return quadTree1
        else:
            tl = self.intersect(quadTree1.topLeft, quadTree2.topLeft)
            tr = self.intersect(quadTree1.topRight, quadTree2.topRight)
            bl = self.intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
            br = self.intersect(quadTree1.bottomRight, quadTree2.bottomRight)
            if tl.isLeaf and tr.isLeaf and bl.isLeaf and br.isLeaf and tl.val == tr.val == bl.val == br.val:
                return Node(tl.val, True, None, None, None, None)
            else:
                return Node(0, False, tl, tr, bl, br)
            