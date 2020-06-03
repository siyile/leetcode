class Solution:
    def makeLargestSpecial(self, S: str) -> str:
        count = i = 0
        res = []
        for j, c in enumerate(S):
            count += 1 if c == '1' else -1
            if count == 0:
                res.append('1' + self.makeLargestSpecial(S[i+1:j]) + '0')
                i = j+1
        return ''.join(sorted(res)[::-1])