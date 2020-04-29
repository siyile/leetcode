import math

class Solution:
    def constructRectangle(self, area: int) -> List[int]:
        w = int(math.sqrt(area))
        while True:
            if area % w == 0:
                return area // w, w
            w -= 1