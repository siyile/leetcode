class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        cnt = 0
        n = len(flowerbed)
        for i in range(n):
            if flowerbed[i] == 0 and  (i == 0 or flowerbed[i - 1] != 1) and (i == n - 1 or flowerbed[i + 1] != 1):
                cnt += 1
                flowerbed[i] = 1
                if i < n - 1 :
                    flowerbed[i + 1] = 2
        return cnt