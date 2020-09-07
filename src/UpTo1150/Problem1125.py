class Solution:
    def smallestSufficientTeam(self, req_skills: List[str], people: List[List[str]]) -> List[int]:
        m = {}
        for i, s in enumerate(req_skills):
            m[s] = 1 << i

        t = 1 << len(req_skills)+1

        dp = [61 for _ in range(t)]
        team = [[] for _ in range(t)]

        dp[0] = 0
        for i, p in enumerate(people):
            s = 0
            for sk in p:
                s |= m[sk]
            
            for j in reversed(range(t)):
                if dp[j|s] > dp[j] + 1:
                    dp[j|s] = dp[j] + 1
                    team[j|s] = team[j].extend(i)

        return team[t-1]
            
