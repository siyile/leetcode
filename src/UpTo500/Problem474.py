from typing import List

class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

        def cnt(s: str):
            cnt_m, cnt_n = 0, 0
            for ch in s:
                if ch == '1':
                    cnt_n += 1
                else:
                    cnt_m += 1
                
            return cnt_m, cnt_n

        for s in strs:
            cnt_m, cnt_n = cnt(s)
            for mm in range(m, -1, -1):
                for nn in range(n, -1, -1):
                    if mm >= cnt_m and nn >= cnt_n:
                        dp[mm][nn] = max(1 + dp[mm - cnt_m][nn - cnt_n], dp[mm][nn])

        return dp[m][n]

if __name__ == "__main__":
    print(Solution().findMaxForm(["10","0001","111001","1","0"],5,3))