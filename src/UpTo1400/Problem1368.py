import collections

class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dirs = [[0,0],[0,1],[0,-1],[1,0],[-1,0]]

        v = set()

        q = collections.deque([(0,0)])
        v.add((0, 0))

        def dfs(node):
            q.append(node)
            x, y = node[0], node[1]
            d = dirs[grid[x][y]]
            x += d[0]
            y += d[1]
            if 0 <= x < m and 0 <= y < n:
                if (x, y) not in v:
                    v.add((x, y))
                    dfs((x, y))
        

        cost = 0

        while q:
            for _ in range(len(q)):
                node = q.popleft()
                v.add(node)
                dfs(node)
            for _ in range(len(q)):
                node = q.popleft()
                if node == (m-1, n-1):
                    return step
                for i in range(1,5):
                    d = dirs[i]
                    x, y = node[0] + d[0], node[1] + d[1]
                    if 0 <= x < m and 0 <= y < n and (x,y) not in v:
                        v.add(x,y)
                        q.append((x,y))
            cost += 1

        


