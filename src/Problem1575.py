class Solution:
    def countRoutes(self, locations: List[int], start: int, finish: int, fuel: int) -> int:
        MOD = 10 ** 9 + 7
        @lru_cache(None)
        def dp(city, fuel):
            ans = 0
            if city == finish:
                ans += 1
            for i, c in enumerate(locations):
                if i == city:
                    continue
                cost = abs(c - locations[city])
                if cost <= fuel:
                    ans += dp(i, fuel - cost)
                    ans %= MOD
            return ans % MOD
        
        return dp(start, fuel)
