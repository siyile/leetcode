class Solution:
    def isPossible(self, target: List[int]) -> bool:
        n = len(target)
        s = sum(target)
        if n == s:
            return True

        maxi = max(target)
        if maxi - (s - maxi) <= 0:
            return False
        idx = target.index(maxi)
        if maxi % (s - maxi) == 0:
            target[idx] = s - maxi
        else:
            target[idx] = maxi % (s - maxi)
        return self.isPossible(target)
        

        