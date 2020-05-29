import random

class Solution:

    def __init__(self, N: int, blacklist: List[int]):
        self.n = N - len(blacklist)
        i = N - 1
        self.m = {}
        s = set(blacklist)
        for num in blacklist:
            if num >= self.n:
                continue
            while(i in blacklist):
                i -= 1
            self.m[num] = i
            i -= 1
    

    def pick(self) -> int:
        x = random.randint(0, self.n)
        return x if x not in self.m else self.m[x]
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(N, blacklist)
# param_1 = obj.pick()