class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        return min([row[0] for row in ops]) * min([row[1] for row in ops]) if ops else 0