from heapq import *

class Solution:
    def networkDelayTime(self, times: List[List[int]], N: int, K: int) -> int:
        v = set()
        graph = [{} for _ in range(N+1)]
        for t in times:
            graph[t[0]][t[1]] = t[2]
        
        h = [(0, K)]
        ans = float('inf')
        while h:
            dis, node = heappop(h)
            if cur in v:
                continue
            v.add(node)
            ans = dis
            for nei in graph[node]:
                if nei not in v:
                    q.append((dis+graph[node][nei], nei))
        
        return -1 if len(v) != N else ans
        
        

