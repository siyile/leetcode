class Solution:
    def minInteger(self, num: str, k: int) -> str:
        n = len(num)
        b = [0] * (n+1)
        
        def add(i, d):
            i += 1
            while i <= n:
                b[i] += d
                i += i & -i

        def sum(i):
            ans = 0
            i += 1
            while i > 0:
                ans += b[i]
                i -= i & -i
            return ans

        q = [[] for i in range(10)]
        for i, c in enumerate(num):
            q[ord(c)-ord('0')].append(i)
        
        for i in range(10):
            q[i] = q[i][::-1]
        
        ans = ''
        for i in range(n):
            for d in range(10):
                if q[d]:
                    pos = q[d][-1]
                    shift = sum(pos-1)
                    if pos - shift <= k:
                        k -= (pos - shift)
                        add(pos, +1)
                        ans += str(d)
                        q[d].pop()
                        break
        
        return ans

        