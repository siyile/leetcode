class Solution:
    def pathsWithMaxScore(self, board):
        mod = 10 ** 9 + 7
        n = len(board)
        dp = [[[0, 0] for _ in range(n+1)] for _ in range(n+1)]
        
        dp[n-1][n-1] = [0, 1]

        for j in range(n-2, -1, -1):
            i = n-1
            while j < n:
                if board[i][j] == 'X':
                    j += 1
                    i -= 1
                    continue
                m = max(dp[i+1][j][0], dp[i][j+1][0], dp[i+1][j+1][0])
                w = 0
                for x, y in [(i+1,j), (i,j+1), (i+1,j+1)]:
                    if dp[x][y][0] == m:
                        w += dp[x][y][1]
                dp[i][j] = [int(board[i][j]) + m, w % mod]
                j += 1
                i -= 1
        
        for i in range(n-2, -1, -1):
            j = 0
            while i >= 0:
                if board[i][j] == 'X':
                    j += 1
                    i -= 1
                    continue
                m = max(dp[i+1][j][0], dp[i][j+1][0], dp[i+1][j+1][0])
                w = 0
                for x, y in [(i+1,j), (i,j+1), (i+1,j+1)]:
                    if dp[x][y][0] == m:
                        w += dp[x][y][1]
                dp[i][j] = [(0 if i == 0 and j == 0 else int(board[i][j])) + m, w % mod]
                j += 1
                i -= 1

        return dp[0][0]
