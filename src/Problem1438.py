from collections import deque
from typing import *

class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        inc = deque()
        dec = deque()

        left = 0
        ans = 0
        for i, num in enumerate(nums):
            while inc and inc[-1] > num:
                inc.pop()
            while dec and dec[-1] < num:
                dec.pop()
            
            inc.append(num)
            dec.append(num)

            while dec[0] - inc[0] > limit:
                if dec[0] == nums[left]:
                    dec.popleft()
                if inc[0] == nums[left]:
                    inc.popleft()
                left += 1
            ans = max(i - left + 1, ans)
        return ans
            
            
if __name__ == "__main__":
    print(Solution().longestSubarray([4,2,2,2,4,4,2,2],0))