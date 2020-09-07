class Solution:
    def numDecodings(self, s: str) -> int:
        if s[0] == '0':
            return 0
        mod = 10**9 + 7
        dp = [0 for _ in range(len(s) + 1)]
        dp[0] = 1
        dp[1] = 1 if s[0] != '*' else 9
        for i in range(2, len(s) + 1):
            c = s[i-1]
            prev = s[i-2]
            cs = s[i-2:i]
            if c != '*':
                if c != '0':
                    dp[i] += dp[i - 1]
                if prev == '*':
                    if '0' <= c <= '6':
                        dp[i] += dp[i - 2] * 2
                    else:
                        dp[i] += dp[i - 2]
                elif 10 <= int(cs) <= 26:
                    dp[i] += dp[i - 2]
            else:
                dp[i] = dp[i - 1] * 9
                if prev == '*':
                    dp[i] += 15 * dp[i - 2]
                elif prev == '1':
                    dp[i] += 9 * dp[i - 2]
                elif prev == '2':
                    dp[i] += 6 * dp[i - 2]
            dp[i] %= mod
        return dp[len(s)]
