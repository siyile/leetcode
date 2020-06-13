class Solution:
    def movesToChessboard(self, b: List[List[int]]) -> int:
        n = len(b)
        if any(b[0][0] ^ b[i][0] ^ b[0][j] ^ b[i][j] for i in range(n) for j in range(n)):
            return -1
        if not n // 2 <= sum(b[0]) <= (n + 1) // 2:
            return -1
        if not n // 2 <= sum(b[i][0] for i in range(n)) <= (n+1) // 2:
            return -1
        col = sum(b[0][i] == i%2 for i in range(n))
        row = sum(b[i][0] == i%2 for i in range(n))
        if n%2:
            if col % 2:
                col = n - col
            if row % 2:
                row = n - row
        else:
            col = min(n - col, col)
            row = min(n - row, row)
        return (col + row) // 2
