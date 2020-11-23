class Solution:
    def isPrintable(self, grid: List[List[int]]) -> bool:
        N = 61
        D = [set() for _ in range(N)]

        m, n = len(grid), len(grid[0])

        for c in range(N):
            b, t, r, l = -1, m, -1, n
            for i in range(m):
                for j in range(n):
                    if c == grid[i][j]:
                        t = min(t, i)
                        b = max(i, b)
                        l = min(l, j)
                        r = max(r, j)
            
            for i in range(t, b+1):
                for j in range(l, r+1):
                    if grid[i][j] != c:
                        D[c].add(grid[i][j])
        
        v = [0] * N

        def circle(c):
            if v[c] == 2:
                return True
            if v[c] == 1:
                return False
            v[c] = 1
            for nei in D[c]:
                if not circle(nei):
                    return False
            v[c] = 2
            return True
        
        for c in range(N):
            if not circle(c):
                return False
        return True
        