class Solution:
    def getLengthOfOptimalCompression(self, s: str, k: int) -> int:
        @lru_cache(None)
        def dp(start, last, lastCount, k):
            if k < 0:
                return float('inf')
            if start == len(s):
                return 0
            if s[start] == last:
                inc = 1 if lastCount == 1 or lastCount == 9 or lastCount == 99 else 0
                return inc + dp(start+1, last, lastCount + 1, k)
            else:
                return min(dp(start+1, s[start], lastCount, k-1), 1 + dp(start+1, s[start], 1, k))
        return dp(0, '', 0, k)