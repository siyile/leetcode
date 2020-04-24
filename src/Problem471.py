class Solution:
    def encode(self, s: str) -> str:
        n = len(s)
        dp = [["" for _ in range(n)] for _ in range(n)]

        for l in range(0, n):
            for i in range(0, n - l):
                j = i + l
                substr = s[i:j + 1]
                if j - i < 4:
                    dp[i][j] = substr
                else:
                    dp[i][j] = substr
                    for k in range(i, j):
                        if len(dp[i][k]) + len(dp[k + 1][j]) < len(dp[i][j]):
                            dp[i][j] = dp[i][k] + dp[k + 1][j]
                        
                    for k in range(len(substr)):
                        rs = substr[0:k+1]
                        if len(substr) % len(rs) == 0 and len(substr.replace(rs, "")) == 0:
                            ss = "" + str(len(substr) // len(rs)) + '[' + dp[i][i + k] + ']'
                            if len(ss) < len(dp[i][j]):
                                dp[i][j] = ss
        return dp[0][n - 1]
