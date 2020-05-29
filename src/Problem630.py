from heapq import *

class Solution:
    def scheduleCourse(self, courses) -> int:
        time = 0
        courses.sort(key=lambda x: x[1])
        pq = []
        for c in courses:
            time += c[0]
            heappush(pq, -c[0])
            if time > c[1]:
                time += heappop(pq)
        return len(pq)



if __name__ == "__main__":
    print(Solution().scheduleCourse([[1,2],[2,3]]))