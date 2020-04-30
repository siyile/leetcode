from heapq import *
from typing import *

dirs = [[1, 0, 'd'], [0, -1, 'l'], [0, 1, 'r'], [-1, 0, 'u']]

class Solution:
    def findShortestWay(self, maze: List[List[int]], ball: List[int], hole: List[int]) -> str:
        impossible = "impossible"
        m, n = len(maze), len(maze[0])
        pq = []
        heapify(pq)
        heappush(pq, (0, (ball[0], ball[1]), ""))
        visited = set()

        while pq:
            steps, (x, y), path = heappop(pq)
            if (x, y) == (hole[0], hole[1]):
                return path

            if (x, y) in visited:
                continue
            visited.add((x, y))
            for dir in dirs:
                xx, yy = x, y
                step = 0
                while xx >= 0 and xx < m and yy >= 0 and yy < n and maze[xx][yy] == 0 and (xx, yy) != (hole[0], hole[1]):
                    xx += dir[0]
                    yy += dir[1]
                    step += 1
                if (xx, yy) != (hole[0], hole[1]):
                    xx -= dir[0]
                    yy -= dir[1]
                    step -= 1
                if (xx, yy) not in visited:
                    heappush(pq, (steps + step, (xx, yy), path + dir[2]))

        
        return impossible

        
if __name__ == "__main__":
    maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]
    print(Solution().findShortestWay(maze, [4,3], [0,1]))