class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        pos = {}
        for i, ch in enumerate(ring):
            if ch not in pos:
                pos[ch] = []
            pos[ch].append(i)

        m = len(ring)
        
        dp = [[100000 for _ in range(len(ring))] for _ in range(len(key) + 1)]

        key = ring[0] + key
        dp[0][0] = 0

        for i, ch in enumerate(key):
            if i == 0:
                continue
            for j in pos[ch]:
                if i == 1:
                    dp[i][j] = min(dp[0][0] + min((j - 0) % m, (0 - j) % m), dp[i][j])
                    continue
                for k in pos[key[i - 1]]:
                    dp[i][j] = min(dp[i - 1][k] + min((j - k) % m, (k - j) % m), dp[i][j])

        ans = 1000000
        for j in pos[key[-1]]:
            ans = min(ans, dp[-1][j])
        ans += len(key) - 1
        return ans