class Solution:
    def countSegments(self, s: str) -> int:
        return sum(s[i] != ' ' and (i == 0 or s[i - 1] == ' ')
                   for i in range(len(s)))