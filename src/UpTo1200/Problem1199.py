from heapq import *

class Solution:
    def minBuildTime(self, blocks: List[int], split: int) -> int:
        heapify(blocks)
        while len(blocks) > 2:
            x1 = heappop(blocks)
            x2 = heappop(blocks)
            heappush(blocks, x1 + x2 + split)
        return blocks[0]
