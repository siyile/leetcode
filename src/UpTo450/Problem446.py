from collections import defaultdict

class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        ans = 0
        dp = [defaultdict(int) for item in A]
        for i in range(len(A)):
            for j in range(0, i):
                diff = A[i] - A[j]
                dp[i][diff] += 1
                if diff in dp[j]:
                    dp[i][diff] += dp[j][diff]
                    ans += dp[j][diff]

        return ans