class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        color = {}
        m, n = len(grid), len(grid[0])
        def dfs(x, y, c):
            if not (0<=x<m and 0<=y<n) or grid[x][y] != 1:
                return 0
            grid[x][y] = c
            res = 1
            res += sum([dfs(i, j, c) for i, j in [(x-1, y), (x+1, y), (x, y+1), (x, y-1)]])
            return res
        
        cur = 2

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    color[cur] = dfs(i, j, cur)
                cur += 1
        
        if not color:
            return 1
        else:
            res = max(color.values())

        for x in range(m):
            for y in range(n):
                if grid[x][y] == 0:
                    s = set()
                    for i, j in [(x-1, y), (x+1, y), (x, y+1), (x, y-1)]:
                        if (0<=i<m and 0<=j<n) and grid[i][j] != 0:
                            s.add(grid[i][j])
                    res = max(res, 1+sum(color[c] for c in s))
        
        return res

        