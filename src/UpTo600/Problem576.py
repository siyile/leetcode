class Solution:
    def findPaths(self, m: int, n: int, N: int, i: int, j: int) -> int:
        module = 10 ** 9 + 7
        dp = [[0 for _ in range(n + 2)] for _ in range(m + 2)]
        ans = 0
        for k in range(N):
            dp1 = [[0 for _ in range(n + 2)] for _ in range(m + 2)]
            if k == 0:
                dp1[i + 1][j + 1] = 1
            else:
                for i in range(1, m + 1):
                    for j in range(1, n + 1):
                        dp1[i][j] = (dp[i - 1][j] + dp[i + 1][j] + dp[i][j - 1] + dp[i][j + 1]) % module
            ans += sum((sum(dp1[1]), sum(dp1[m]), sum([row[1] + row[n] for row in dp1])))
            dp = dp1
        
        return ans % module

if __name__ == "__main__":
    Solution().findPaths(2, 2, 2, 0, 0)