import random
from typing import *

class Solution:
    
    def __init__(self, n_rows: int, n_cols: int):
        self.m = n_rows
        self.n = n_cols    
        self.map = {}
        self.total = self.m * self.n

    def flip(self) -> List[int]:
        num = random.randrange(self.total)
        self.total -= 1
        x = self.map.get(num, num)
        self.map[num] = self.map.get(self.total, self.total)
        return [x // self.m, x % self.m]

    def reset(self) -> None:
        self.map = {}
        
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(n_rows, n_cols)
# param_1 = obj.flip()
# obj.reset()

if __name__ == "__main__":
    s = Solution(2, 2)
    for i in range(4):
        print(s.flip())
