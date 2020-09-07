class Solution:
    def maxSatisfaction(self, sat: List[int]) -> int:
        sat.sort()
        n = len(sat)
        cur = 0
        total = 0
        ans = 0
        for i in range(1, n+1):
            cur += sat[-i]
            total += cur
            ans = max(ans, total)
        return ans
