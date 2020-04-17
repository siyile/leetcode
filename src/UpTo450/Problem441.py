def possible(row: int, target: int) -> bool:
    return row * (1 + row) // 2 <= target


class Solution:
    def arrangeCoins(self, n: int) -> int:
        left, right = 0, 2 ** 31 -1
        while left < right:
            mid = (right + left) // 2 + 1
            if possible(mid, n):
                left = mid
            else:
                right = mid - 1
        return left
