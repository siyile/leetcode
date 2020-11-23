from typing import *

class Solution:
    def candyCrush(self, board: List[List[int]]) -> List[List[int]]:
        m, n = len(board), len(board[0])
        while True:
            stable = set()

            for i in range(m):
                for j in range(n):
                    if board[i][j] == 0:
                        continue
                    if i > 1 and board[i][j] == board[i-1][j] == board[i-2][j]:
                        stable |= {(i, j), (i-1, j), (i-2, j)}
                    if j > 1 and board[i][j] == board[i][j-1] == board[i][j-2]:
                        stable |= {(i, j), (i, j-1), (i, j-2)}
            
            if stable:
                for i, j in stable:
                    board[i][j] = 0
            else:
                return board
            
            for j in range(n):
                idx = m-1
                for i in range(m-1, -1, -1):
                    if board[i][j]:
                        board[idx][j] = board[i][j]
                        idx -= 1
                for i in range(idx, -1, -1):
                    board[i][j] = 0

if __name__ == "__main__":
    print(Solution().candyCrush([[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]))