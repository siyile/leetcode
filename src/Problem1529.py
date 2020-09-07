from functools import lru_cache

class Solution:
    def numberOfWays(self, num_people: int) -> int:
        mod = 10 ** 9 + 7

        @lru_cache(None)
        def dp(i):
            if i % 2 == 1:
                return 0
            if i == 2:
                return 1
            res = 0
            for j in range(2, i-1, 2):
                res += dp(j) * dp(i-j)
                res %= mod
            return res
        
        return dp(num_people)

if __name__ == "__main__":
    print(Solution().numberOfWays(2))