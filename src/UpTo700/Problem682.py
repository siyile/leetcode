class Solution:
    def calPoints(self, ops: List[str]) -> int:
        h = []
        for op in ops:
            if op == 'C':
                h.pop()
            elif op == 'D':
                h.append(h[-1] * 2)
            elif op == '+':
                h.append(h[-1] + h[-2])
            else:
                h.append(int(op))
        
        return sum(h)