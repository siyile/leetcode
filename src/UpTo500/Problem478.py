import math
import random

class Solution:

    def __init__(self, radius: float, x_center: float, y_center: float):
        self.radius = radius
        self.x_center = x_center
        self.y_center = y_center

    def randPoint(self) -> List[float]:
        len = math.sqrt(random.random()) * self.radius
        deg = random.random() * 2 * math.pi
        x = self.x_center + len * math.cos(deg)
        y = self.y_center + len * math.sin(deg)
        return [x, y]



# Your Solution object will be instantiated and called as such:
# obj = Solution(radius, x_center, y_center)
# param_1 = obj.randPoint()