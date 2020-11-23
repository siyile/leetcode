class Solution:
    def findReplaceString(self, S: str, indexes: List[int], sources: List[str], targets: List[str]) -> str:
        ans = ''
        i = 0
        j = 0
        n = len(S)
        m = len(indexes)

        command = []
        for i in range(m):
            command.append((indexes[i], sources[i], targets[i]))
        command.sort()

        for j in range(m):
            ans += s[i:command[j][0]]
            i = command[j][0]
            if S[i:i+len(command[j][1])] == command[j][1]:
                ans += command[j][2]
            else:
                ans += S[i:i+len(command[i][1])]
            i += len(command[j][1])
        
        ans += s[i:]

        return ans