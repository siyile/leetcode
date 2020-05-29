from collections import defaultdict

class Solution:
    def countPalindromicSubsequences(self, S: str) -> int:
        mod = 10**9 + 7
        n = len(S)
        left = [-1 for _ in range(n)]
        right = [-1 for _ in range(n)]
        last = defaultdict(lambda : -1)
        for i in range(n):
            left[i] = last[S[i]]
            last[S[i]] = i
        last.clear()
        for i in range(n - 1, -1, -1):
            right[i] = last[S[i]]
            last[S[i]] = i
        
        dp = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1

        for l in range(1, n):
            for i in range(0, n - l):
                j = i + l
                if S[i] != S[j]:
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]
                else:
                    # a...a
                    if right[i] == j:
                        dp[i][j] = dp[i+1][j-1] * 2 + 2
                    # a...a...a
                    elif right[i] == left[j]:
                        dp[i][j] = dp[i+1][j-1] * 2 + 1
                    # a..a...a...a
                    else:
                        dp[i][j] = dp[i+1][j-1] * 2 - dp[right[i]+1][left[j]-1]
                dp[i][j] %= mod
        return dp[0][n-1]

    
            
if __name__ == "__main__":
    print(Solution().countPalindromicSubsequences('abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'))