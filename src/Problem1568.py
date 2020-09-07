import copy

class Solution:
    def minDays(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        def check2components():
            ng = copy.deepcopy(grid)

            def dfs(i, j):
                if i >= m or j >= n or i < 0 or j < 0 or ng[i][j] == 0:
                    return
                ng[i][j] = 0
                dfs(i, j+1)
                dfs(i, j-1)
                dfs(i+1, j)
                dfs(i-1, j)

            cnt = 0
            for x in range(m):
                for y in range(n):
                    if ng[i][j]:
                        cnt += 1
                        dfs(i, j)
            
            return cnt >= 2
        
        # Zero day
        if check2components():
            return 0
        
        # One day
        for i in range(m):
            for j in range(n):
                if grid[i][j]:
                    grid[i][j] = 0
                    if check2components():
                        return 1
                    grid[i][j] = 1

        # others
        return 2
        


