import collections

class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        queue = collections.deque()
        # [cur, previous, num_step]
        queue.append([start, start, 0])
        
        while queue:
            current, previous, num_step = queue.popleft()
            if current == end:
                return num_step
            for mutation in bank:
                if mutation != previous and self.viableMutation(mutation, current):
                    queue.append([mutation, current, num_step + 1])
        
        return -1
    
    def viableMutation(self, seq1: str, seq2: str) -> bool:
        change = 0
        for i in range(8):
            if seq1[i] != seq2[i]:
                change += 1
        return change == 1
    
