from collections import deque

class Solution:
    def maxCandies(self, status: List[int], candies: List[int], keys: List[List[int]], containedBoxes: List[List[int]], initialBoxes: List[int]) -> int:
        if not initialBoxes:
            return 0
        v = set()
        box = set()
        q = deque()
        for b in initialBoxes:
            if status[b] == 1:
                q.append(b)
                v.add(b)
            else:
                box.add(b)
        if not q:
            return 0
        ans = 0
        while q:
            for _ in range(len(q)):
                b = q.popleft()
                for k in keys[b]:
                    status[k] = 1
                ans += candies[b]
                for bb in containedBoxes[b]:
                    if bb not in v:
                        box.add(bb)
            for b in list(box):
                if b not in v and status[b] == 1:
                    q.append(b)
                    box.remove(b)
                    v.add(b)
        return ans
            


            