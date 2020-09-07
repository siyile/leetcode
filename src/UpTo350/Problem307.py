from typing import List

class BinaryIndexTree:

    def __init__(self, nums: List[int]):
        self.n: int = len(nums) + 1
        self.bit: List[int] = [0] * self.n
        for i, num in enumerate(nums):
            self.add(i, num)
    
    def add(self, i: int, d: int) -> None:
        i += 1
        while i < self.n:
            self.bit[i] += d
            i += i & -i
    
    def sum(self, i: int) -> int:
        i += 1
        ans: int = 0
        while i > 0:
            ans += self.bit[i]
            i -= i & -i
        return ans
    
    # inclusive
    def rangeSum(self, l: int, r: int) -> int:
        return self.sum(r) - self.sum(l-1)


class NumArray:

    def __init__(self, nums: List[int]):
        self.bit = BinaryIndexTree(nums)
        self.A = nums

    def update(self, i: int, val: int) -> None:
        self.bit.add(i, val - self.A[i])
        self.A[i] = val

    def sumRange(self, i: int, j: int) -> int:
        return self.bit.rangeSum(i, j)