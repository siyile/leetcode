class Solution:
    def frequencySort(self, s: str) -> str:
        freq = {}
        maxCount = 0
        for c in s:
            freq[c] = freq.get(c, 0) + 1
            maxCount = max(maxCount, freq[c])
        
        l = [None for _ in range(maxCount + 1)]
        
        for key, value in freq.items():
            if l[value] == None:
                l[value] = []
            l[value].append(key)

        ans = ""
        
        for i in range(maxCount, 0, -1):
            if l[i] != None:
                for c in l[i]:
                    ans += c * i
        
        return ans

