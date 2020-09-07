class Solution:
    def minDifficulty(self, A: List[int], d: int) -> int:
        n = len(A)

        dp = [[float('inf') for _ in range(n)] for _ in range(d)]

        dp[0][0] = A[0]
        for i in range(1, n):
            dp[0][i] = max(dp[0][i-1], A[i])
        
        for i in range(1, d):
            for l in range(i, n):
                local = 0
                for r in range(n-1, l-1, -1):
                    local = max(local, A[r])
                    dp[i][l] = min(dp[i][l], dp[i-1][r-1] + local)
        
        return dp[d-1][n-1] if dp[d-1][n-1] != float('inf') else -1