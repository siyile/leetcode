class Solution:
    def findPermutation(self, s: str) -> List[int]:
        ans = []
        upper = 0
        cur = 0
        s = "I" + s

        for i in range(len(s)):
            if s[i] == 'I':
                j = i + 1
                cnt = 1
                while j < len(s) and s[j] == 'D':
                    cnt += 1
                    j += 1
                upper += cnt
                ans.append(upper)
                cur = upper - 1
            else:
                ans.append(cur)
                cur -= 1

        return ans
