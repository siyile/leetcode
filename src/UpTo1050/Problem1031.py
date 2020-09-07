class Solution:
    def maxSumTwoNoOverlap(self, A: List[int], L: int, M: int) -> int:
        n = len(A)
        ans = 0
        def max2():
            left = 0
            right = 0
            for i in range(L):
                left += A[i]

            for j in range(L, M+L):
                right += A[i]
            ans = max(anx, left + right)
            leftMax = left
            for i in range(M+L, n):
                rs = i - M
                ls = rs - L

                right += A[i]
                right -= A[rs]
                left += A[rs]
                left -= A[ls]
                maxLeft = max(maxLeft, left)
                ans = max(maxLeft +  right, ans)
        
        max2()
        A = A[::-1]
        max2()
        return ans



            