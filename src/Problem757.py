class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: x[1])
        m1, m2 = -1, -1
        ans = 0
        for i in intervals:
            start, end = i[0], i[1]
            if start > m2:
                ans += 2
                m2, m1 = end-1, end
            elif start > m1:
                ans += 1
                m2, m1 = end-1 if m1 == end else m1, end
        return ans