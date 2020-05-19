class Solution:
    def minDistance(self, height: int, width: int, tree: List[int], squirrel: List[int], nuts: List[List[int]]) -> int:
        return sum(map(lambda x: abs(x[0] - tree[0]) + abs(x[1] - tree[1]), nuts)) * 2 + min(map(lambda x: abs(x[0] - squirrel[0]) + abs(x[1] - squirrel[1]) - abs(x[0] - tree[0]) - abs(x[1] - tree[1]), nuts))
