from collections import deque

class Solution:
    def numMatchingSubseq(self, S: str, words: List[str]) -> int:
        qs = [deque() for _ in range(26)]

        def getIndex(c):
            return ord(c) - ord('a')

        for w in words:
            qs[getIndex(w[0])].append(w)


        ans = 0
        for c in S:
            q = qs[getIndex(c)]
            for _ in range(q):
                w = q.popleft()
                if len(w) == 1:
                    ans += 1
                else:
                    qs[getIndex(w[1])].append(w[1:])
        
        return ans


    

