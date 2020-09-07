class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        l = [0] * 10
        s = 0
        for d in digits:
            s += d
            l[d] += 1
        remainder = s % 3

        found = False
        if s % 3 == 1:
            for d in [1,4,7]:
                if l[d] != 0:
                    l[d] -= 1
                    found = True
                    break
            if not found:
                k = 2
                for d in [2, 5, 8]:
                    if l[d] >= 0:
                        c = max(k, l[d])
                        l[d] -= c
                        k -= c
        elif s % 3 == 2:
            for d in [2, 5, 8]:
                if l[d] != 0:
                    l[d] -= 1
                    found = True
                    break
            if not found:
                k = 2
                for d in [2, 5, 8]:
                    if l[d] >= 0:
                        c = max(k, l[d])
                        l[d] -= c
                        k -= c
        
        res = ""

        for i in range(9, 0, -1):
            res += str(i) * l[i]
        
        if res != "":
            res += '0' * l[0]
        else:
            res = '0' if l[0] else ''
        
        return res
        

        

        
            