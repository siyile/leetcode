from collections import Counter

class Solution:
    def findLHS(self, nums: List[int]) -> int:
        d = Counter(nums)
        ans = 0
        for num, value in d.items():
            if num + 1 in d:
                ans = max(ans, value + d[num + 1])
        return ans