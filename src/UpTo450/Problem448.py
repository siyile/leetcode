class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            if nums[num - 1] > 0:
                nums[num - 1] *= -1
        
        ans = []
        for i, num in enumerate(nums):
            if num > 0:
                ans.append(i + 1)
        return ans