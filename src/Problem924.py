class disjoint_set:
    
    def __init__(self, n):
        self.rank = [0] * n
        self.parent = [i for i in range(n)]
    
    def find(self, x):
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        x, y = self.find(x), self.find(y)
        if self.rank[x] > self.rank[y]:
            self.parent[y] = x
        else:
            self.parent[x] = y
            if self.rank[x] == self.rank[y]:
                self.rank[y] += 1
    
    def size(self):
        s = set()
        for x in self.parent:
            s.add(x)
        return len(s)


class Solution:
    def minMalwareSpread(self, graph: List[List[int]], initial: List[int]) -> int:


        n = len(graph)
        ds = disjoint_set(n)

        for i in range(n):
            for j in range(i+1, n):
                if graph[i][j]:
                    ds.union(i, j)
        
        from collections import defaultdict
        m = defaultdict(int)
        for i in range(n):
            m[ds.find(i)] += 1
        
        m1 = defaultdict(int)
        for i in initial:
            m1[ds.find(i)] += 1
        
        if sorted(m1.values())[0] > 1:
            return sorted(initial)[0]
        
        f = []

        for i in initial:
            if m1[ds.find(i)] == 1:
                f.append(i)
        
        x = max(m[i] for i in f)

        for i in sorted(f):
            if m[i] == x:
                return i


        
        
        

