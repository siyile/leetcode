class Solution:
    def distinctEchoSubstrings(self, text: str) -> int:
        base = 29
        mod = 1441622671
        n = len(text)
        hash = [0] * (n+1)
        pow = [0] * (n+1)
        pow[0] = 1
        for i in range(1, n+1):
            pow[i] = base * pow[i-1] % mod
            hash[i] = (hash[i-1] * base + ord(text[i-1])) % mod

        def getHash(l, r):
            return (hash[r] - hash[l] * pow[r-l]) % mod

        res = set()
        
        for s in range(1, 1 + n // 2):
            for i in range(0, n-s*2+1):
                mid = i + s
                hash1 = getHash(i, mid)
                hash2 = getHash(mid, mid+s)
                if (hash1 == hash2):
                    res.add(hash1)
        
        return len(res)
