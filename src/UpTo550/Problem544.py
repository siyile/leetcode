class Solution:
    def findContestMatch(self, n: int) -> str:
        res = list(map(str, range(1, n+1)))
        while n > 1:
            res = ["(" + res[i] + "," + res[n-1-i] + ")" for i in range(n >> 1)]
            n >>= 1
        return res[0]

if __name__ == "__main__":
    print(Solution().findContestMatch(8))