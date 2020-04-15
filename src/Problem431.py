class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children

class Codec:
    # Encodes an n-ary tree to a binary tree.
    def encode(self, root: 'Node') -> TreeNode:
        if root == None:
            return None

        node0 = TreeNode(root.val)

        node = node0
        node.right = TreeNode(len(root.children))
        node = node.right
        for child in root.children:
            node.left = self.decode(child)
            node = node.left

        return node0

	
	# Decodes your binary tree to an n-ary tree.
    def decode(self, data: TreeNode) -> 'Node':
        if data == None:
            return None

        node = Node(data.val, [])
        data = data.right
        for _ in range(data.val):
            data = data.left
            node.children.append(self.decode(data))
            
        return node