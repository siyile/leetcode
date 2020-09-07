class Solution:
    def palindromePartition(self, s: str, k: int) -> int:
        n = len(s)
        def cost(i, j):
            c = 0
            while i < j:
                if s[i] != s[j]:
                    c += 1
                i += 1
                j -=1
            return c
        
        @lru_cache(None)
        def dp(i, k):
            if k == 1:
                return cost(i, n-1)
            if n - i == k:
                return 0
            res = float('inf')

            for j in range (i+1, n - k + 2):
                res = min(res, cost(i, j-1) + dp(j, k-1))
            
            return res

        return dp(0, k)
