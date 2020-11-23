class disjoint_set:
    def __init__(self, n):
        self.rank = [0] * n
        self.size = [1] * n
        self.max = 1
        self.parent = [i for i in range(n)]
    
    def find(self, x):
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        x, y = self.find(x), self.find(y)
        if x == y:
            return
        if self.rank[x] > self.rank[y]:
            self.parent[y] = x
            self.size[x] += self.size[y]
        else:
            self.parent[x] = y
            self.size[y] += self.size[x]
            if self.rank[x] == self.rank[y]:
                self.rank[y] += 1
        self.max = max(self.max, self.size[x], self.size[y])
    
    def group(self):
        s = set()
        for x in self.parent:
            s.add(self.find(x))
        return len(s)
    
    def get_max(self):
        return self.max

class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        n = len(stones)
        ds = disjoint_set(n)

        row = [[] for _ in range(10000)]
        col = [[] for _ in range(10000)]
        for i, s in enumerate(stones):
            row[s[0]].append(i)
            col[s[1]].append(i)
        
        for r in row:
            for i in range(1, len(r)):
                ds.union(r[i], r[i-1])
        
        for c in col:
            for i in range(1, len(c)):
                ds.union(c[i], c[i-1])
        
        return n-ds.group()
            