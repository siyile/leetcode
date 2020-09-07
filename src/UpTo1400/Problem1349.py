class Solution:
    def maxStudents(self, seats: List[List[str]]) -> int:
        m, n = len(seats), len(seats[0])

        dp = [[-1 for _ in range(1 << n)] for _ in range(m+1)]
        dp[0][0] = 0

        valids = []

        for i in range(m):
            cur = 0
            seat = seats[i]
            for j in range(n):
                cur = (cur<<1) + (1 if seat[j] == '.' else 0)
            valids.append(cur)

        @functools.lru_cache(256)
        def countBit(i):
            if i == 0:
                return 0
            return countBit(i>>1) + i % 2 
        
        for i in range(m):
            valid = valids[i]
            for j in range(1 << n):
                if (valid | j) == valid and (j & j >> 1) == 0: 
                    for k in range(1 << n):
                        if dp[i][k] != -1 and (k & j>>1) == 0 and (k >> 1 & j) == 0:
                            dp[i+1][j] = max(dp[i+1][j], dp[i][k] + countBit(j))
        
        return max(dp[m])

