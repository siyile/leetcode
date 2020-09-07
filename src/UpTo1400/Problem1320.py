class Solution:
    def minimumDistance(self, word: str) -> int:
        n = 6
        l = len(word)

        @lru_cache(None)
        def dis(a, b):
            t1 = ord(a) - ord('A')
            t2 = ord(b) - ord('A')
            x1, y1 = t1 // n, t1 % n
            x2, y2 = t2 // n, t2 % n
            return abs(x1-x2) + abs(y1-y2)

        # i > j
        @lru_cache(None)
        def dp(i, j):
            if i == l-1:
                return 0
            return min(dp(i+1, j) + (dis(word[i+1], word[i]) if i != -1 else 0), dp(i+1, i) + (dis(word[i+1], word[j]) if j != -1 else 0))

        return dp(-1, -1)