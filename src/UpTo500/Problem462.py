def partition(lo, hi, nums):
    i, j, pivot = lo, lo, nums[hi]
    while j < len(nums) - 1:
        if nums[j] < pivot:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
        j += 1
    nums[i], nums[hi] = nums[hi], nums[i]
    return i

class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        k = len(nums) // 2
        lo = 0
        hi = len(nums) - 1
        while lo < hi:
            pivot = partition(lo, hi, nums)

            if pivot == k:
                break
            elif pivot < k:
                lo = pivot + 1
            else:
                hi = pivot - 1
        
        return sum(map(lambda x: abs(nums[pivot] - x), nums))