class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        n = len(row)
        ptn = lambda x : x^1
        pos = [0] * n

        for i, x in enumerate(row):
            pos[x] = i
        
        ans = 0
        for i in range(n):
            j = row[ptn(pos[ptn(i)])]
            while i != j:
                ans += 1
                pos[i], pos[j] = pos[j], pos[i]
                row[pos[i]], row[pos[j]] = row[pos[j]], row[pos[i]]
                i = j
                j = row[ptn(pos[ptn(i)])]

        return ans
