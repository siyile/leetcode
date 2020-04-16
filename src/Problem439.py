class Solution:
    def parseTernary(self, exp: str) -> str:
        stack = []
        i = len(exp) - 1
        while i >= 0:
            if len(stack) > 0 and stack[-1] == '?':
                stack.pop()
                first = stack.pop()
                stack.pop()
                second = stack.pop()
                stack.append(first if exp[i] == 'T' else second)
            else:
                stack.append(exp[i])
            i -= 1
        return str(stack[0])
