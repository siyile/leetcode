class Solution:
    def findSubstringInWraproundString(self, p: str) -> int:
        count = [0 for _ in range(26)]

        length = 0
        for i in range(len(p)):
            length = length + 1 if i == 0 or (ord(p[i]) - ord(p[i - 1])) % 26 == 1 else 1
            count[ord(p[i]) - ord('a')] = max(count[ord(p[i]) - ord('a')], length)
        

        return sum(count)