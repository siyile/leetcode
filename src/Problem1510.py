class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        
        @lru_cache(None)
        def dp(i):
            if i == 0:
                return False
            return any(not dp(i-x*x) for x in range(round(sqrt(i)), 0, -1))

        return dp(n)
                