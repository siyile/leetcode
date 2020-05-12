from collections import Counter

class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        if k < 0:
            return 0
        if k == 0:
            cnt = 0
            s = Counter(nums)
            for val in s.values():
                if val > 1:
                    cnt += 1
            return cnt
        s = set(nums)
        cnt = 0
        for num in sorted(s):
            if num + k in s:
                cnt += 1
        return cnt    
