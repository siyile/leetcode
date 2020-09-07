import itertools

class Solution:
    def numOfArrays(self, N: int, M: int, K: int) -> int:
        dp = [[[0 for _ in range(M + 1)] for _ in range(K + 1)] for _ in range(N + 1)]
        
        for m in range(1, M + 1):
            dp[1][1][m] = 1

        for n, k, m in itertools.product(range(1, N + 1), range(1, K + 1), range(1, M + 1)):
            dp[n][k][m] += dp[n - 1][k][m] * m
            dp[n][k][m] += sum(dp[n - 1][k - 1][1:m])

        return sum(dp[n][k][1:]) % (10 ** 9 + 7)