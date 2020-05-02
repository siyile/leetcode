class Solution:
    def convertToBase7(self, num: int) -> str:
        if num == 0:
            return "0"
        sign = num > 0
        num = abs(num)
        i = 0
        x = 1
        while x <= num:
            x *= 7
            i += 1

        x //= 7
        ans = ""
        while i > 0:
            ans += str(num // x)
            num -= (num // x) * x
            x /= 7
            i -= 1
        
        return ("" if sign else "-") + str(ans)
