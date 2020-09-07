from collections import deque
from functools import lru_cache

class Solution:
    def shortestPathLength(self, graph) -> int:
        big_int = 10000
        ans = big_int
        n = len(graph)

        dis = [[big_int for _ in range(n)] for _ in range(n)]

        for i in range(n):
            q = deque([i])
            v = set([i])
            d = 0
            while q:
                for _ in range(len(q)):
                    j = q.popleft()
                    dis[i][j] = dis[j][i] = d
                    for node in graph[j]:
                        if node not in v:
                            v.add(node)
                            q.append(node)
                d += 1

        
        @lru_cache(None)
        def dfs(i, j):
            if j == 0:
                return 0
            ans = big_int
            for m in range(n):
                if (j&1<<m) > 0:
                    ans = min(ans, dfs(m, j&~(1<<m)) + dis[m][i])
            return ans
        

        return min([dfs(i, ((1<<n)-1)&~(1<<i)) for i in range(n)])
            
            
if __name__ == "__main__":
    print(Solution().shortestPathLength([[1],[0,2,4],[1,3,4],[2],[1,2]]))
