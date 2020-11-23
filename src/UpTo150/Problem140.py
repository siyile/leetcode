class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        @lru_cache(None)
        def b(s):
            if not s:
                return ['']
            ans = []
            for word in wordDict:
                if s.startswith(word):
                    for suffix in b(s[len(word):]):
                        if suffix:
                            ans.append(word + ' ' + suffix)
                        else:
                            ans.append(word)
            return ans

        return b(s)