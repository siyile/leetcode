class Solution:
    def lastSubstring(self, s: str) -> str:
        i = k = 0
        j = 1
        n = len(s)
        while i < n and j < n:
            if s[i+k] == s[j+k]:
                k += 1
                continue
            elif s[i+k] > s[j+k]:
                j = j+k+1
            elif s[i+k] < s[j+k]:
                i = i+k+1
            if i == j:
                j += 1
            k = 0
        return s[(i if i != n else j):] 