import math

class Solution:
    def minmaxGasDist(self, stations: List[int], K: int) -> float:
        l, r = 0, 1e8
        n = len(stations)
        while r - l > 1e-7:
            m = (l + r) / 2
            count = 0
            for i in range(1, n):
                if stations[i] - stations[i-1] > m:
                    count += math.ceil((stations[i] - stations[i-1]) / m) - 1
            if count >= K:
                l = m
            else:
                r = m
        return l