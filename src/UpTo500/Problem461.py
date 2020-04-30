class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        ans = 0
        z = x ^ y
        while z > 0:
            ans += 1
            z &= (z - 1)
        
        return ans