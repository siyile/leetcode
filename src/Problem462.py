class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        nums_sum = sum(nums)
        return sum(map(lambda x: nums_sum - x * len(nums), nums)) / len(nums)