class Solution:
    def countOrders(self, n: int) -> int:
        MOD = 10 ** 9 + 7
        c = 2
        for i in range(1, n):
            c = (c + (2 *i + 1)**2 * (i + 1)) % MOD
        return c
