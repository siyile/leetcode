from collections import deque
from typing import *

class Solution:
    def minNumberOfSemesters(self, n: int, dependencies: List[List[int]], k: int) -> int:
        dp = [n] * (1 << n)
        
        prev = [0] * n
        for d in dependencies:
            prev[d[1] - 1] |= 1 << (d[0] - 1)

        dp[0] = 0
        
        for cur in range(1 << n):
            can = 0
            for i, p in enumerate(prev):
                if (p & cur) == p :
                    can |= 1 << i
            
            can &= ~cur

            sub = can

            while sub > 0:
                if bin(sub).count("1") <= k:
                    dp[sub | cur] = min(dp[sub | cur], dp[cur] + 1)
                sub = (sub - 1) & can
        
        return dp[-1]


print(Solution().minNumberOfSemesters(4, [[2,1],[3,1],[1,4]], 2))