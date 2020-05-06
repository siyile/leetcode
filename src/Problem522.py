class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        # is s2 a sub seq of s1
        def isSubSeq(s1, s2):
            if len(s2) > len(s1):
                return False
            i = 0
            for c in s1:
                if i < len(s2) and c == s2[i]:
                    i += 1
            return len(s2) == i

        strs.sort(key = len, reverse = True)
        for i, s1 in enumerate(strs):
            if all(not isSubSeq(s2, s1) for j, s2 in enumerate(strs) if i != j):
                return len(s1)
        return -1

