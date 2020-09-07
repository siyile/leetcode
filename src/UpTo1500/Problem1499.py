from collections import deque

class Solution:
    def findMaxValueOfEquation(self, points: List[List[int]], k: int) -> int:
        q = deque()
        n = len(points)
        ans = float('-inf')
        for i in range(n):
            while q:
                if -points[q[0]][0] + points[i][0] > k:
                    q.popleft()
                else:
                    break
            if q:
                ans = max(ans, points[q[0]][1] + points[i][1] + points[i][0] - points[q[0]][0])
            while q:
                if points[q[-1]][1] <= points[i][1]:
                    q.pop()
                else:
                    break
            q.append(i)
        return ans 