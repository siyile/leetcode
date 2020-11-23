class Solution:
    def checkValidString(self, s: str) -> bool:
        cmin, cmax = 0, 0
        for c in s:
            if c == '(':
                cmin += 1
                cmax += 1
            if c == ')':
                cmin -= 1
                cmax -= 1
                if cmax < 0:
                    return False
            if c == '*':
                cmin -= 1
                cmax += 1
            cmin = max(0, cmin)
        return cmax == 0