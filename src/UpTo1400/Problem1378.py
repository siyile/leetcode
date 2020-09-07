class Solution:
    def maxSizeSlices(self, slices: List[int]) -> int:
        m = len(slices)
        n = m // 3


        def f(A):

            dp = [[0 for _ in range(n+1)] for _ in range(m+1)]

            for i in range(1, m-1+1):
                for j in range(1, n+1):
                    if j == 1:
                        dp[i][j] = A[i-1]
                    else:
                        dp[i][j] = max(A[i-1] + dp[i-2][j-1], dp[i-1][j])
            
            return dp[m][n]
        
        return max(f(slices[1:]), f(slices[:-1]))