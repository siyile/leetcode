from typing import *

def getNext(i, nums):
    n = len(nums)
    return (i + nums[i]) % n

class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                continue
            val = nums[i]
            j = i
            k = getNext(i, nums)
            while nums[k] * val > 0 and nums[getNext(k, nums)] * val > 0:
                if j == k:
                    if j == getNext(j, nums):
                        break
                    return True
                j = getNext(j, nums)
                k = getNext(getNext(k, nums), nums)
            
            j = i
            while nums[j] * val > 0:
                next = getNext(j, nums)
                nums[j] = 0
                j = next

        return False

if __name__ == "__main__":
    print(Solution().circularArrayLoop([2,1,1,-1]))