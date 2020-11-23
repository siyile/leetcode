class Solution:
    def minimumOneBitOperations(self, n: int) -> int:
        if n == 0:
            return 0
        t = n
        cnt = 0
        while t > 0:
            t >>= 1
            cnt = (cnt << 1) + 1

        return cnt - self.minimumOneBitOperations(cnt - (cnt + 1) >> 1)