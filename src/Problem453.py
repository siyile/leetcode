class Solution:
    def minMoves(self, nums: List[int]) -> int:
        minCnt = min(nums)
        return sum(map(lambda x: x - minCnt, nums))