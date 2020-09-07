class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        dp = {}
        dp[0] = 0

        from collections import defaultdict

        for r in rods:
            cur = defaultdict(int)
            for l in dp:
                cur[l-r] = max(cur[l-r], dp[l])
                cur[l] = max(cur[l], dp[l])
                cur[l+r] = max(cur[l+r], dp[l]+r)
            dp = cur
        return dp[0]