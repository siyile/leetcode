
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
    def findCriticalAndPseudoCriticalEdges(self, n: int, E: List[List[int]]) -> List[List[int]]:
        edges = []
        for i, e in enumerate(E):
            edges.append((e[2], e[0], e[1], i))
        edges.sort()

        def getMST(block, preEdge):
            w = 0
            un = disjoint_set(n)

            if preEdge != -1:
                e = edges[preEdge]
                w += e[0]
                un.union(e[1], e[2])
            
            for i, e in enumerate(edges):
                if i == block:
                    continue
                if (un.find(e[1]) != un.find(e[2])):
                    un.union(e[1], e[2])
                    w += e[0]
            
            if un.group() > 1:
                return float('inf')
            
            return w
        
        base = getMST(-1, -1)

        cr = []
        ncr = []

        for i in range(len(edges)):
            # block
            if getMST(i, -1) > base:
                cr.append(edges[i][3])
            elif getMST(-1, i) == base:
                ncr.append(edges[i][3])
        
        return [cr, ncr]
