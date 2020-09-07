class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        m = {}
        m['a'] = 0
        m['e'] = 1
        m['i'] = 2
        m['o'] = 3
        m['u'] = 4

        dp = [float('inf')] * 32
        cur = 0
        ans = 0
        for i, c in enumerate(s):
            cur ^= 1 << m[c]
            ans = max(ans, i - dp[cur])
            if dp[cur] == float('inf'):
                dp[cur] = i
        
        return ans