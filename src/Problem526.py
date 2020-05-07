class Solution:
    def countArrangement(self, N: int) -> int:
        nums = [i for i in range(1, N + 1)]

        def helper(start, count):
            if start == -1:
                return count + 1
            for i in range(start, -1, -1):
                nums[start], nums[i] = nums[i], nums[start]
                if nums[start] % (start + 1) == 0 or (start + 1) % nums[start] == 0:
                    count = helper(start - 1, count)
                nums[start], nums[i] = nums[i], nums[start]
            return count

        return helper(N - 1, 0)