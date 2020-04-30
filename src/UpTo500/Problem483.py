class Solution:
    def smallestGoodBase(self, n: str) -> str:
        n = int(n)
        for k in range(60, 1, -1):
            s, e = 2, n
            while s <= e:
                x = (e - s) // 2 + s
                cmp = n * (x - 1) - x ** k + 1
                if cmp == 0:
                    return str(x)
                elif cmp > 0:
                    s = x + 1
                else:
                    e = x - 1
                    
        
        return ""

if __name__ == "__main__":
    print(Solution().smallestGoodBase('13'))