class Solution:
    def isSolvable(self, words, result: str) -> bool:
        s = set()
        f = set()
        for word in words:
            f.add(word[0])
            for c in word:
                s.add(c)
        for c in result:
            s.add(c)
        l = list(s)

        v = [False] * 10

        d = {}

        def check():
            su = 0
            for word in words:
                ss = 0
                for c in word:
                    ss = ss * 10 + d[c]
                su += ss
            sss = 0
            for c in result:
                sss = sss * 10 + d[c]
            return sss == su

        def bt(i):
            if i == len(l):
                if check():
                    return True
                return False
            for j in range(10):
                if not v[j]:
                    d[l[i]] = j
                    v[j] = True
                    if bt(i+1):
                        return True
                    v[j] = False
                    del d[l[i]]
            return False
        
        return bt(0)


print(Solution().isSolvable(["LEET","CODE"], "POINT"))