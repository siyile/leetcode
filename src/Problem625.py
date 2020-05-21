class Solution:
    def smallestFactorization(self, N):
        if N == 1:
            return 1
            
        A = []
        while N > 1:
            for d in range(9, 1, -1):
                if N % d == 0:
                    N /= d
                    A.append(d)
                    break
            else:
                return 0
        
        ans = int("".join(map(str, A[::-1])))
        return ans if ans < 2**31 else 0