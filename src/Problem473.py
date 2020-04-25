def helper(start, cur, n_done, nums, a):
    if cur > a:
        return False
    if cur == a:
        if n_done == 3:
            for num in nums:
                if num != 0:
                    return False
            return True
        else:
            return helper(0, 0, n_done + 1, nums, a)
    
    for i in range(start, len(nums)):
        if nums[i] == 0:
            continue
        temp = nums[i]
        nums[i] = 0
        if helper(i + 1, cur + temp, n_done, nums, a):
            return True
        nums[i] = temp

    return False



class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        n = len(nums)
        a = sum(nums) / 4
        if n == 0:
            return False

        nums.sort(reverse = True)
        
        return helper(0, 0, 0, nums, a)

