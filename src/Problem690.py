class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        block = False
        buffer = ''
        ans = []
        for s in source:
            i = 0
            n = len(s)
            while i < n:
                if block:
                    if s[i] == '*' and i < n - 1 and s[i+1] == '/' :
                        block = False
                        i += 1
                else:
                    if s[i] == '/' and i < n - 1 and s[i+1] == '*':
                        block = True
                        i += 1
                    elif s[i] == '/' and i < n - 1 and s[i+1] == '/':
                        i += 1
                        break
                    else:
                        buffer += s[i]
                i += 1
            if not block and buffer:
                ans.append(buffer)
                buffer = ''
        return ans
        