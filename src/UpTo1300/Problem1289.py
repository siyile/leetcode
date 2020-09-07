class Solution:
    def minFallingPathSum(self, arr: List[List[int]]) -> int:
        n = len(arr)
        dp = [0] * n
        for i in range(n):
            dp1 = [0] * n
            for j in range(n):
                dp1[j] = min((dp[k] + arr[i][k]) if k != j else float('inf') for k in range(n))
            dp = dp1
        return min(dp)