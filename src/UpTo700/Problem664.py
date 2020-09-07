from functools import lru_cache
import re

class Solution:
    def strangePrinter(self, s: str) -> int:
        s = re.sub(r'(.)\1*', r'\1', s)
        @lru_cache(None)
        def dp(l, r):
            if l > r:
                return 0
            ans = dp(l + 1, r) + 1
            for i in range(l + 1, r + 1):
                if s[i] == s[l]:
                    ans = min(ans, dp(l, i - 1) + dp(i + 1, r))
            return ans

        return dp(0, len(s) - 1)

if __name__ == "__main__":
    print(Solution().strangePrinter("abc"))





