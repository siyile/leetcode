class Solution:
    def longestDecomposition(self, text: str) -> int:
        p = 213144523
        lo, hi = 0, len(text)-1

        lh = hh = k = l = 0
        while lo < hi:
            lh *= 26
            lh += ord(text[lo]) - 97

            hh += pow(26, l, p) * (ord(text[hi]) - 97)

            hh %= p
            lh %= p

            if hh == lh:
                k += 2
                hh = lh = l = 0
            else:
                l += 1
            
            lo += 1
            hi -= 1
        
        if (l == 0 and lo == hi) or l > 0:
            k += 1
        
        return k

