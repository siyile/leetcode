import collections

class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        dp = nums[:1]
        decerase = collections.deque(dp)
        for i, x in enumerate(nums[1:], 1):
            if i > k and dp[i - k - 1] == decerase[0]:
                decerase.popleft()
            tmp = max(x, x + decerase[0])
            while decerase and decerase[-1] < tmp:
                decerase.pop()
            decerase.append(tmp)
        return max(dp)
            