class Solution:
    def connectTwoGroups(self, cost: List[List[int]]) -> int:
        dp = [[float('inf') for _ in range(1 << 12)] for _ in range(13)]

        m, n = len(cost), len(cost[0])

        dp[0][0] = 0

        for i in range(1, m+1):
            for mask in range(1 << 12):
                for j in range(n):
                    if (mask & 1 << j) > 0:
                        dp[i][mask] = min(dp[i][mask], dp[i-1][mask & ~(1<<j)] + cost[i-1][j])

        mini = [float('inf')] * n
        for i in range(m):
            for j in range(n):
                mini[j] = min(mini[j], cost[i][j])
        
        ans = float('inf')
        for mask in range(1<<12):
            ans = min(ans, dp[m][mask] + sum([0 if (1 << i & mask) > 0 else mini[i] for i in range(n)]))

        return ans