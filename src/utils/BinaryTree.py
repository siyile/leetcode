class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    

def height(root: TreeNode) -> int:
    if not root:
        return 0
    return max(height(root.left), height(root.right)) + 1

def sum(root: TreeNode) -> int:
    if not root:
        return 0
    return sum(root.left) + sum(root.right) + root.val