class Solution:
    def cheapestJump(self, A: List[int], B: int) -> List[int]:
        n = len(A)
        if n == 1:
            return [1]
        dp = [100 * 1000] * n
        dp[n - 1] = 0
        route = [-1] * n
        for i in range(n - 1, -1, -1):
            for j in range(i + 1, min(n, i + B + 1)):
                if A[j] != -1:
                    if dp[j] + A[j] < dp[i]:
                        dp[i] = dp[j] + A[j]
                        route[i] = j
        if route[0] == -1:
            return []
        else:
            ans = []
            curr = 0
            ans.append(curr + 1)
            while route[curr] != -1:
                curr = route[curr]
                ans.append(curr + 1)
            return ans