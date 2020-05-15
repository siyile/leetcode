class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        ans = 0
        for i in range(len(nums)):
            num = nums[i]
            if num < 0:
                continue
            nums[i] = -1
            cur = 1
            while nums[num] >= 0:
                tmp = num
                num = nums[num]
                nums[tmp] = -1
                cur += 1
            ans = max(ans, cur)
        
        return ans
                
