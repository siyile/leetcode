class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        return sum(max(0, target[i]-target[i+1]) for i in range(len(target)-1)) + target[0]