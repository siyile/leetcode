@functools.lru_cache(None)
def win(status: int, remaining: int) -> bool:
    i, j = 1, 1
    while i <= status:
        if (i & status > 0):
            if j >= remaining:
                return True
            if not win(status & ~i, remaining - j):
                return True
        j += 1
        i <<= 1
    
    return False
        

class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        if sum(i + 1 for i in range(maxChoosableInteger)) < desiredTotal:
            return False
        status = 2 ** maxChoosableInteger - 1
        return win(status, desiredTotal)

if __name__ == "__main__":
    print(Solution().canIWin(20, 168))