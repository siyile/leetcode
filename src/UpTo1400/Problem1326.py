class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:
        n += 1
        A = []
        for i, r in enumerate(ranges):
            A.append([max(0, i-r), min(n-1, i+r)])

        A.sort(key = lambda x, y: y)
        
        dp = [101 for _ in range(n)]

        dp[0] = 0
        for a in A:
            s, e = a
            for i in range(s, e+1):
                dp[i] = min(dp[i], dp[s]+1)            

        return dp[n-1]


