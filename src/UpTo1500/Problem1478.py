class Solution:
    def minDistance(self, houses: List[int], k: int) -> int:
        houses.sort()
        n = len(houses)
        cost = [[0 for _ in range(n)] for _ in range(n)]

        for i in range(n):
            for j in range(i, n):
                med = houses[(i+j)//2]
                c = 0
                for t in range(i, j+1):
                    c += abs(med - houses[t])
                cost[i][j] = c
        
        @lru_cache(None)
        def dp(i, k):
            if k == 0 and i == n:
                return 0
            if k == 0 or i == n:
                return float('inf')
            c = float('inf')
            for j in range(i, n):
                c = min(c, cost[i][j] + dp(j+1, k-1))
            return c
        
        return dp(0, k)