class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        fr = "qwertyuiopQWERTYUIOP"
        sr = "asdfghjklASDFGHJKL"
        tr = "zxcvmbnZXCNBVNM"
        ans = []
        for word in words:
            f = 0
            s = 0
            t = 0
            for ch in word:
                if ch in fr:
                    f = 1
                if ch in sr:
                    s = 1
                if ch in tr:
                    t = 1
                if s + t + f != 1:
                    break
            if s + t + f == 1:
                ans.append(word)
        return ans
            
                    
