class Solution:
    def countOfAtoms(self, formula: str) -> str:
        cnt = {}
        s = []
        n = len(formula)
        i = 0
        while i < n:
            c = formula[i]
            if c == '(':
                s.append(cnt)
                cnt = {}
            elif c == ')':
                j = i + 1
                while j < n and formula[j].isdigit():
                    j += 1
                mult = int(formula[i+1:j])
                tmp = cnt
                cnt = s.pop()
                for el, num in tmp.items():
                    if el in cnt:
                        cnt[el] += num * mult
                    else:
                        cnt[el] = num * mult
                i = j - 1
            else:
                j = i + 1
                while j < n and formula[j].islower():
                    j += 1
                el = formula[i:j]
                mult = 1
                if j < n and formula[j].isdigit():
                    k = j + 1
                    while k < n and formula[k].isdigit():
                        k += 1
                    mult = int(formula[j:k])
                    j = k
                if el in cnt:
                    cnt[el] += mult
                else:
                    cnt[el] = mult
                i = j - 1
            i += 1
        ans = ""
        for el in sorted(cnt):
            ans += el
            if cnt[el] != 1:
                ans += str(cnt[el])
        return ans

if __name__ == "__main__":
    print(Solution().countOfAtoms('K4(ON(SO3)2)2'))