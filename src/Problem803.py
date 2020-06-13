class Solution:
    def hitBricks(self, grid: List[List[int]], hits: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])

        def dfs(i, j):
            if not(0<=i<m and 0<=j<n) or grid[i][j] != 1:
                return 0
            res = 1
            grid[i][j] = 2
            return res + sum(dfs(x, y) for (x, y) in [(i-1, j), (i+1, j), (i, j+1),(i, j-1)])
        
        def is_connected(i, j):
            return i==0 or any([0<=x<m and 0<=y<n and grid[x][y]==2 for (x, y) in [(i-1, j), (i+1, j), (i, j+1),(i, j-1)]])
        
        for (x, y) in hits:
            grid[x][y] -= 1
        
        res = [0 * len(hits)]

        for i in range(n):
            dfs(0, i)

        for k in reversed(range(len(hits))):
            x, y = hits[k]
            grid[x][y] += 1
            if grid[x][y] == 1 and is_connected(x, y):
                res[k] = dfs(x, y) - 1
        
        return res
    