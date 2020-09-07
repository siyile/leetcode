from collections import deque

class Solution:
    def frogPosition(self, n: int, edges: List[List[int]], t: int, target: int) -> float:
        q = deque([(1,1)])
        g = [set() for _ in range(n+1)]
        for e in edges:
            g[e[0]].add(e[1])
            g[e[1]].add(e[0])
        
        v = set([1])

        if n == 1:
            return 1

        while t:
            t -= 1
            for _ in range(len(q)):
                node, p = q.popleft()
                if len(g[node]) == 1 and node != 1:
                    q.append((node, p))
                    continue
                for nei in g[node]:
                    if nei not in v:
                        v.add(nei)
                        if node == 1:
                            np = 1 / len(g[node])
                        else:
                            np = 1 / (len(g[node]) - 1)

                        q.append((nei,p*np))
        
        for tu in q:
            node, p = tu
            if node == target:
                return p
        
        return 0