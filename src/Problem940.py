class Solution:
    def distinctSubseqII(self, S: str) -> int:
        s = 0
        end = [0] * 26
        for c in S:
            i = ord(c) - ord('a')
            t = s - end[i] + 1
            end[i] = s + 1
            s += t
        
        return s % (10 ** 9 + 7)