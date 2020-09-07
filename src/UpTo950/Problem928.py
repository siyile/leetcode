class Solution:
    
    def minMalwareSpread(self, graph: List[List[int]], initial: List[int]) -> int:
        from collections import defaultdict, deque

        m = defaultdict(list)
        n = len(graph)
        for i in initial:
            q = deque([i])
            v = set(initial)
            while q:
                x = q.popleft()
                for j in range(n):
                    if not graph[x][j]:
                        continue
                    if j in v:
                        continue
                    v.add(j)
                    q.append(j)
                    m[j].append(i)
        
        res = [0] * n
        for key in m:
            if len(m[key]) == 1:
                res[m[key][0]] += 1

        if sum(res) == 0:
            return min(initial)
        else:
            return res.index(max(res))
        