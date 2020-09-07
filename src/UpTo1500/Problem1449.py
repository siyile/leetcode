class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[[float('-inf') for _ in range(n)] for _ in range(n)] for _ in range(m)]
        dp[0][0][-1] = grid[0][0] + grid[0][-1]

        for i in range(1, m):
            for j in range(n):
                for k in range(n):
                    for x in range(j-1, j+2):
                        for y in range(k-1, k+2):
                            if 0 <= x < n and 0 <= y < n:
                                dp[i][j][k] = max(dp[i][j][k], dp[i-1][x][y] + grid[i][k] + (grid[i][j] if j != k else 0))

        return max(map(max, dp[-1]))