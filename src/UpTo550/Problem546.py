from functools import lru_cache
from typing import *

class Solution:
    def removeBoxes(self, boxes: List[int]) -> int:

        @lru_cache(None)
        def dp(i, j, k):
            if i > j:
                return 0
            if i == j:
                return (k + 1) * (k + 1)
            while i + 1 <= j and boxes[i + 1] == boxes[i]:
                k += 1
                i += 1
            
            res = (k + 1) ** 2 + dp(i + 1, j, 0)

            m = i + 1
            while m <= j:
                if boxes[m] == boxes[i]:
                    res = max(res, dp(i + 1, m - 1, 0) + dp(m, j, k + 1))
                m += 1
            
            return res
        
        return dp(0, len(boxes) - 1, 0)
                

if __name__ == "__main__":
    print(Solution().removeBoxes([1,3,2,2,2,3,4,3,1]))