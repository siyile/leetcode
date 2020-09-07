class Solution:
    def numDupDigitsAtMostN(self, N: int) -> int:
        def f(n):
            if n == 0 or n == 1: return 1
            return f(n-1) * n
        # pick m out of n, ordred matters
        def P(m, n): return f(n) // f(n - m)
        
        # N + 1 as padding.
        nums = [int(d) for d in str(N + 1)]
        K = len(nums) # N has K digits
        cnt = 0 # number with no repeated val

        # calculate less than N digit
        for i in range(1, K): cnt += 9 * P(i-1, 9)

        # calculate have same prefix
        s = set()
        for i in range(K):
            for x in range(1 if i == 0 else 1, nums[i]):
                if x not in s:
                    cnt += P(K-i-1, 10-i-1)
            if nums[i] in s:
                break
            s.add(nums[i])
        
        return N - cnt