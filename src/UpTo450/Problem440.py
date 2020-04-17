def calSteps(n: int, n1: int, n2: int) -> int:
    step = 0
    while n1 <= n:
        step += min(n2, n + 1) - n1
        n1 *= 10
        n2 *= 10

    return step

class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        cur = 1
        k -= 1
        steps = 0
        while k > 0:
            step = calSteps(n, cur, cur + 1)
            if (step <= k):
                cur += 1
                k -= step
            else:
                cur *= 10
                k -= 1

        return cur