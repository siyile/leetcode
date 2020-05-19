from typing import *

class Solution:
    def matrixReshape(self, nums: List[List[int]], r: int, c: int) -> List[List[int]]:
        m, n = len(nums), len(nums[0])
        cur = 0
        a = [[0 for _ in range(c)] for _ in range(r)]
        if r * c != m * n:
            return nums
        for i in range(r):
            for j in range(c):
                a[i][j] = nums[cur // n][cur % n]
                cur += 1
        return a


if __name__ == "__main__":
    Solution().matrixReshape([[1,2],[3,4]], 4, 1)