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
    
    def size(self):
        s = set()
        for x in self.parent:
            s.add(x)
        return len(s)
    
    def get_max(self):
        return self.max


class Solution:
    def largestComponentSize(self, A: List[int]) -> int:

        def prime(number):
            # Initialize a list
            primes = []
            for pr in range(2, number+1):
                isPrime = True
                for num in range(2, int(pr ** 0.5) + 1):
                    if pr % num == 0:
                        isPrime = False
                        break
                if isPrime:
                    primes.append(pr)
            return primes
        
        primes = prime(100000)
        s = set(primes)

        ds = disjoint_set(len(A))
        m = {}
        for i, a in enumerate(A):
            if a in s:
                if a in m:
                    ds.union(i, m[a])
                else:
                    m[a] = i
                continue
            for p in primes:
                if a % p == 0:
                    if p in m:
                        ds.union(i, m[p])
                    else:
                        m[p] = i
        
        
        return ds.get_max()

                

        