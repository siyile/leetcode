class RLEIterator:

    def __init__(self, A: List[int]):
        n = len(A)
        self.q = deque()
        for i in range(0, n, 2):
            q.append((A[i], A[i+1]))

    def next(self, n: int) -> int:
        ans = -1
        while n > 0:
            if not q:
                return -1
            d = min(q[0][0], n)
            q[0][0] -= d
            n -= d
            ans = q[0][1]
            if q[0][0] == 0:
                q.popleft()
        return ans
        


# Your RLEIterator object will be instantiated and called as such:
# obj = RLEIterator(A)
# param_1 = obj.next(n)