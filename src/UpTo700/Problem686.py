class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        la, lb = len(a), len(b)

        times = ceil(lb / la)
        s = a * times

        if s.find(b) != -1:
            return times
        
        s += a
        if s.find(b) != -1:
            return times + 1
        
        
        return -1