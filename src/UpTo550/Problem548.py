class Solution:
    def splitArray(self, nums: List[int]) -> bool:
        n = len(nums)
        if n < 7:
            return False
        for j in range(3, n - 3):
            sum1 = sum(nums[:j])
            s1 = set()
            cur = nums[0]
            for i in range(1, j - 1):
                if sum1 - cur - nums[i] == cur:
                    s1.add(cur)
                cur += nums[i]
            
            sum2 = sum(nums[j + 1:])
            s2 = set()
            cur = nums[j + 1]
            for k in range(j + 2, n - 1):
                if sum2 - cur - nums[k] == cur:
                    s2.add(cur)
                cur += nums[k]

            if s1.intersection(s2):
                return True
        return False
            

