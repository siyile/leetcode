class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        stamp = sorted(map(lambda x: int(x[:2]) * 60 + int(x[3:]), timePoints))
        ans = 24 * 60
        for i, t in enumerate(stamp):
            ans = min(ans, (stamp[(i + 1) % len(stamp)] - stamp[i] + 24 * 60) % (24 * 60))
        return ans
