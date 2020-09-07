class Solution:
    def maximizeSweetness(self, sweetness: List[int], K: int) -> int:
        l, r = 0, 10 ** 9
        while l < r:
            m = (l + r + 1) // 2
            k = 0
            cur = 0
            for s in sweetness:
                cur += s
                if cur > m:
                    cur = 0
                    k += 1
            if k < K:
                r = m - 1
            else:
                l = m

        return l

        