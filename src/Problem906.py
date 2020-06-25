class Solution:
    def superpalindromesInRange(self, L: str, R: str) -> int:
        res = [i for i in range(1, 10)]
        for i in range(1,10000):
            s1 = str(i) + str(i)[::-1]
            res.append(s1)
            for j in range(10):
                s2 = str(i) + str(j) + str(i)[::-1]
                res.append(s2)
        
        def isPalin(s):
            return s == s[::-1]
        
        res = list(map(int, res))
        res.sort()
        ans = []
        for val in res:
            s = str(val**2)
            if isPalin(s):
                ans.append(int(s))
        
        l, r = 0, len(ans) - 1
        L, R = int(L), int(R)
        while l < len(ans) and ans[l] < L:
            l += 1
        while r >= 0 and ans[r] > R:
            r -= 1

        return r - l + 1