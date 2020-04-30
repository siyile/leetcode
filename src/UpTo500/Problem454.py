def getSum(A: List[int], B: List[int]):
    ans = {}
    for a in A:
        for b in B:
            ans[a + b] = ans.get(a + b, 0) + 1
    return ans


class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        sum1 = getSum(A, B)
        sum2 = getSum(C, D)

        ans = 0
        for a in sum1:
            ans += sum1[a] * sum2.get(-a, 0)
        
        return ans