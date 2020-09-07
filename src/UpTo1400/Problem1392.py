class Solution:
    def longestPrefix(self, s: str) -> str:
        n = len(s)
        lps = [0] * n
        j = 0
        for i in range(1, n):
            if s[i] == s[j]:
                j += 1
                lps[i] = j
            else:
                while j > 0:
                    j = lps[j-1]
                    if s[j] == s[i]:
                        j += 1
                        break
                lps[i] = j
        return s[:lps[-1]]