class Solution:
    def findLonelyPixel(self, picture: List[List[str]]) -> int:
        m, n = len(picture), len(picture[0])
        col = [0 for _ in range(n)]
        row = [0 for _ in range(m)]
        ans = 0
        for i in range(m):
            for j in range(n):
                if picture[i][j] == 'B':
                    col[j] += 1
                    row[i] += 1
        
        for i in range(m):
            if row[i] == 1:
                for j in range(n):
                    if picture[i][j] == 'B' and col[j] == 1:
                        ans += 1
        return ans
