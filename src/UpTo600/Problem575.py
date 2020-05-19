from collections import Counter

class Solution:
    def distributeCandies(self, candies: List[int]) -> int:
        return min(len(Counter(candies)), len(candies) // 2)