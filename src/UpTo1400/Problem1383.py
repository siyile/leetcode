from heapq import *

class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        mod = 10 ** 9 + 7
        h = []
        ans = 0
        for i in range(n):
            ans = max(ans, efficiency[i] * speed[i])
            h.append((-efficiency[i], speed[i]))
        
        heapify(h)
        s = 0
        e = float('inf')

        h1 = []

        while k:
            k -= 1
            ce, cs = heappop(h)
            ce = ce * -1
            e = ce
            s += cs
            ans = max(ans, s * e)
            h1.append((s, ce))
        
        heapify(h1)

        while h:
            ce, cs = heappop(h)
            ce *= -1

            if cs < h1[0][0]:
                os, oe = heappop(h1)
                s += -os + cs
                e = ce

                heappush(h1, (cs, ce))

                ans = max(ans, s * e)
        

        return ans % mod