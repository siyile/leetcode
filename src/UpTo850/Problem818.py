class Solution:
    def racecar(self, target: int) -> int:
        dp = [float('inf')] * (target+1)
        dp[0] = 0
        for i in range(1, target+1):
            j, m = 1, 1
            while j < i:
                p, q = 0, 0
                while p < j:
                    dp[i] = min(m + 1 + q + 1 + dp[i-(j-p)], dp[i])
                    q += 1
                    p = 2**q - 1
                m += 1
                j = 2**m - 1
            dp[i] = min(dp[i], m if i==j else dp[j-i] + m + 1)
        return dp[target]
                
if __name__ == "__main__":
    print(Solution().racecar(5))