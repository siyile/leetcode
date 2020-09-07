class Solution:
    def numberWays(self, hats) -> int:
        MOD = 10 ** 9 + 7
        n = len(hats)
        t = 1 << n
        people = [[] for _ in range(41)]
        for i, hat in enumerate(hats):
            for h in hat:
                people[h].append(i)
        
        dp = [[0 for _ in range(t)] for _ in range(41)]

        dp[0][0] = 1

        for i in range(1,41):
            for mask in range(t):
                dp[i][mask] = dp[i-1][mask]
                for p in people[i]:
                    if (mask & 1 << p) > 0: 
                        dp[i][mask] = (dp[i][mask] + dp[i-1][mask & ~(1 << p)]) % MOD
        
        ans = max(dp[i][t-1] for i in range(40))
        return dp[40][t-1]
    
if __name__ == "__main__":
    print(Solution().numberWays([[3,4],[4,5],[5]]))
        
