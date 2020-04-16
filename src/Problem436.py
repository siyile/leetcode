import bisect

class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        a = sorted((e[0], i) for (i, e) in enumerate(intervals))
        res = []
        for e in intervals:
            r = bisect.bisect_left(a, (e[1], ))
            res.append(a[r][1] if r != len(a) else - 1)
        
        return res