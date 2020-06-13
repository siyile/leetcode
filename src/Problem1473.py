from functools import lru_cache

class Solution:
    def minCost(self, houses: List[int], cost: List[List[int]], M: int, N: int, T: int) -> int:
        inf_max = 10**7 + 1
        dp = [[[inf_max for _ in range(T+1)] for _ in range(N+1)] for _ in range(M)]
        
        if houses[0] != 0:
            dp[0][houses[0]][1] = 0
        else:
            for n in range(N):
                dp[0][n+1][1] = cost[0][n]


        for m in range(1, M):
            if houses[m] == 0:
                for n in range(1, N+1):
                    for p in range(1, N+1):
                        for t in range(1, T+1):
                            dp[m][n][t] = min(dp[m][n][t], dp[m-1][p][t if n==p else t-1] + cost[m][n-1])
            else:
                n = houses[m]
                for p in range(1, N+1):
                        for t in range(1, T+1):
                            dp[m][n][t] = min(dp[m][n][t], dp[m-1][p][t if n==p else t-1])
        
        res = min(dp[M-1][n][T] for n in range(1,N+1))
        return -1 if inf_max == res else res
    
    def minCost(self, houses: List[int], cost: List[List[int]], M: int, N: int, T: int) -> int:

        @lru_cache(None)
        def dfs(i, t, p):
            if i == M or t < 0 or M - i < t:
                return 0 if i == M and t == 0 else float('inf')
            
            if houses[i] == 0:
                return min(dfs(i+1, t - (c!=p), c) + cost[i][c-1] for c in range(1,N+1))
            else:
                return dfs(i+1, t - (p!=houses[i]), houses[i])
    
        res = dfs(0, T, -1)
        return res if res < float('inf') else -1