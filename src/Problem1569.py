class Solution:
    def numOfWays(self, nums: List[int]) -> int:
        MOD = 10 ** 9 + 7
        
        def dfs(nums):
            n = len(nums)
            if n <= 2:
                return 1
            
            left = []
            right = []
            for i in range(1,n):
                if nums[i] < nums[0]:
                    left.append(nums[i])
                else:
                    right.append(nums[i])
            
            rl = dfs(left)
            rr = dfs(right)

            return comb(n-1,len(left)) * rl % MOD * rr % MOD
        
        return dfs(nums) - 1