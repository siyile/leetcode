class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        n = len(arr)
        mina = [0] * n
        mina[n-1] = arr[n-1]
        for i in range(n-2, -1, -1):
            mina[i] = min(mina[i+1], arr[i])
        maxa = -1
        res = 0
        for i in range(n):
            maxa = max(maxa, arr[i])
            if (maxa <= mina[i]):
                res += 1
        return res