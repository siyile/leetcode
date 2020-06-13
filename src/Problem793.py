class Solution:
    def preimageSizeFZF(self, K: int) -> int:
        def num(x):
            res = 0
            while x:
                res += x // 5
                x //= 5
            return res
        
        l, r = 0, (K + 1) * 5
        while l < r:
            m = (r + l) // 2
            k = num(m)
            if k > K:
                r = m -1
            elif k < K:
                l = m + 1
            else:
                return 5
        return 0

    

