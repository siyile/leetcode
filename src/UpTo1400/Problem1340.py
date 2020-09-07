class Solution:
    def maxJumps(self, arr: List[int], D: int) -> int:
        
        @lru_cache(None)
        def dfs(i):
            res = 0
            for d in range(1, D+1):
                j = i - d
                if j < 0 or arr[j] >= arr[i]:
                    break
                res = max(res, dfs(j))
            for d in range(1, D+1):
                j = i + d
                if j >= len(arr) or arr[j] >= arr[i]:
                    break
                res = max(res, dfs(j))
            
            return res + 1
        

        return max(dfs(i) for i in range(len(arr)))