class Solution:
    def mostSimilar(self, n: int, roads: List[List[int]], names: List[str], targetPath: List[str]) -> List[int]:
        m = len(names)
        n = len(targetPath)
        dp = [[n+1 for _ in range(m)] for _ in range(n)]
        prev = [[0 for _ in range(m)] for _ in range(n)]

        graph = [set() for _ in range(m)]

        for i, r in enumerate(roads):
            graph[r[0]].add(r[1])
            graph[r[1]].add(r[0])
        
        for i in range(m):
            dp[0][i] = 0 if targetPath[0] == names[i] else 1
        
        for i in range(1, n):
            for j in range(m):
                for k in graph[j]:
                    if dp[i-1][j] < dp[i][k]:
                        dp[i][k] = dp[i-1][j] + (1 if targetPath[i] != names[k] else 0)
                        prev[i][k] = j
        
        path = []
        cur = n
        ans = n+1
        for i in range(m):
            if dp[-1][i] < ans:
                ans = dp[-1][i]
                cur = i

        path.append(cur)
        
        for i in range(n-1, 0, -1):
            cur = prev[i][cur]
            path.append(cur)

        return path[::-1]