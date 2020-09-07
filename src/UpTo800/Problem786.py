from heapq import *

class Solution:
    def kthSmallestPrimeFraction(self, A: List[int], K: int) -> List[int]:
        A.sort()
        n = len(A)
        h = [(A[0]/A[i], i, 0) for i in range(n-1, 0, -1)]
        while K > 1:
            _, i, j = heappop(h)
            if j + 1 < i:
                heappush(h, (A[j+1]/A[i], i, j+1))
            K -= 1
        _, i, j = heappop(h)
        return A[j], A[i]

        