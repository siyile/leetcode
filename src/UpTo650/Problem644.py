class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        def check(x) -> bool:
            a = list(map(lambda y: y - x, nums))
            cur = sum(a[:k])
            last = 0
            if cur >= 0:
                return True
            for i in range(k, len(nums)):
                cur += a[i]
                last += a[i - k]
                if last < 0:
                    cur -= last
                    last = 0
                if cur >= 0:
                    return True
            return False
        
        r = 2**32 - 1
        l = -2**32 
        while r - l > 10e-6:
            m = (l + r) / 2
            if check(m):
                l = m
            else:
                r = m
        return l