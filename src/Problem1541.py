class Solution:
    def longestAwesome(self, s: str) -> int:
        dp = [float('inf')] * 1024
        dp[0] = -1
        cur = 0
        ans = 0
        for i, c in enumerate(s):
            d = ord(c) - ord('0')
            cur ^= 1 << d
            ans = max(i - dp[cur], ans)
            for k in range(10):
                ans = max(ans, i - dp[cur ^ 1 << k])
            
            dp[cur] = i
        
        return ans