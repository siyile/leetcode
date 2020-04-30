class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        k = 1
        l, r = 0, 0
        cnt = 0
        ans = 0
        for r in range(len(nums)):
            if nums[r] == 0:
                cnt += 1
            while cnt > k:
                if nums[l] == 0:
                    cnt -= 1
                l += 1
            ans = max(ans, r - l + 1)
        return ans