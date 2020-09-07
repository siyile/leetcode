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
        n = 0
        for i, x in enumerate(self.parent):
            if i == x:
                n += 1
        return n


class Solution:
    def numSimilarGroups(self, A: List[str]) -> int:
        ds = disjoint_set(len(A))

        def sim(s, s1):
            res = 0
            for i in range(len(s)):
                if s[i] != s1[i]:
                    res += 1
                if res > 2:
                    break
            return res <= 2

        for i in range(len(A)):
            for j in range(i+1, len(A)):
                if sim(A[i], A[j]):
                    ds.union(i, j)
        
        return ds.size()

if __name__ == "__main__":
    print(Solution(numSimilarGroups()))
        

        

        