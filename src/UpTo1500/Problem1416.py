from collections import defaultdict

class Solution:
    def numberWays(self, hats: List[List[int]]) -> int:
        MOD = 10 ** 9 + 7
        n = len(hats)
        t = 1 << 40

        dp = [defaultdict(int) for i in range(n)]
        for i in range(n):
            for mask, cnt in dp[i].items():
                for h in hats[i]:
                    h -= 1
                    if (mask & 1 << h) == 0:
                        dp[i+1][mask | 1 << h] = (cnt + dp[i+1][mask | 1 << h]) % MOD
        
        return sum(dp[n].values()) % MOD
