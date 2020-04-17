from collections import defaultdict

class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        ans = 0
        for i, p1 in enumerate(points):
            dis = defaultdict(int)
            for j, p2 in enumerate(points):
                if i != j:
                    dis[(p2[1] - p1[1]) ** 2 + (p2[0] - p1[0]) ** 2] += 1
            for cnt in dis.values():
                ans += cnt * (cnt - 1)
        return ans

