class Solution:
    def findIntegers(self, num: int) -> int:
        s = format(num, 'b')[::-1]
        n = len(s)
        ones = [0 for _ in range(n)]
        zeros = [0 for _ in range(n)]
        ones[0] = 1
        zeros[0] = 1

        for i in range(1, n):
            zeros[i] = zeros[i - 1] + ones[i - 1]
            ones[i] = zeros[i - 1]
        
        res = zeros[n - 1] + ones[n - 1]

        for i in range(n - 2, -1, -1):
            if s[i] == '0' and s[i + 1] == '0':
                res -= ones[i]
            elif s[i] == '1' and s[i + 1] == '1':
                break
        return res
