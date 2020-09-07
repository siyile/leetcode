from collections import deque

class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        m, n = len(grid), len(grid[0])
        s = set()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    x, y = i, j
                if grid[i][j].islower():
                    s.add(grid[i][j]) 
        k = len(s)

        q = deque([(x, y, 0)])
        v = set()
        step = 0

        while q:
            for _ in range(len(q)):
                x, y, state = q.popleft()
                if str(state) + "," + str(x) + ',' + str(y) in v:
                    continue
                v.add(str(state) + "," + str(x) + ',' + str(y))
                if state == (1 << k) - 1:
                    return step
                for i, j in [(x-1, y), (x+1,y), (x, y-1), (x, y+1)]:
                    if 0 <= i < m and 0 <= j < n:
                        if grid[i][j] == '#':
                            continue
                        if grid[i][j].islower():
                            q.append((i, j, state | 1 << ord(grid[i][j]) - ord('a')))
                        if grid[i][j] == '.' or grid[i][j] == '@' or grid[i][j].isupper() and (state & 1 << ord(grid[i][j]) - ord('A')) > 0:
                            q.append((i, j, state))
            step += 1
        
        return -1