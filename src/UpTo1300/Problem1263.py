from collections import deque
from heapq import *

class Solution:
    def minPushBox(self, grid) -> int:
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        def hash(b, p):
            return f'{b[0]}-{b[1]}-{p[0]}-{p[1]}'

        t, b, p = [], [], []
        
        m, n = len(grid), len(grid[0])

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 'S':
                    p = [i, j]
                elif grid[i][j] == 'T':
                    t = [i, j]
                elif grid[i][j] == 'B':
                    b = [i, j]

        q = [(0, p, b)]
        v = set()

        while (q):
            step, p, b = heappop(q)
            if hash(b, p) in v:
                continue
            v.add(hash(b, p))
            for d in dirs:
                p1 = [p[0]+d[0], p[1]+d[1]]
                if 0 <= p1[0] < m and 0 <= p1[1] < n and  grid[p1[0]][p1[1]] != '#':
                    # touch box
                    if p1[0] == b[0] and p1[1] == b[1]:
                        b1 = [b[0]+d[0], b[1]+d[1]]
                        if 0 <= b1[0] < m and 0 <= b1[1] < n and grid[b1[0]][b1[1]] != '#':
                            if b[0] == t[0] and b[1] == t[1]:
                                return step+1
                            if hash(b1, p1) not in v:
                                heappush(q, (step+1, p1, b1))
                    # not touch
                    else:
                        if hash(b, p1) not in v:
                            heappush(q, (step, p1, b))
        
        return -1

print(Solution().minPushBox([['T','B','S']]))