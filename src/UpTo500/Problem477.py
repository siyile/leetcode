class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        ans = 0
        n = len(nums)
        for i in range(31):
            bit_count = 0
            for num in nums:
                if (num & 1 << i) > 0:
                    bit_count += 1
            ans += bit_count * (n - bit_count)
        
        return ans