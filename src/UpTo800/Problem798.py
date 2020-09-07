class Solution:
    def bestRotation(self, A: List[int]) -> int:
        n = len(A)
        c = [1] * n
        for i, num in enumerate(A):
            c[(A[i] - i + n + 1) % n] -= 1
        for i in range(1, n):
            c[i+1] += c[i]
        return c.index(max(c))