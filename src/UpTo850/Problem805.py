class Solution:
    def splitArraySameAverage(self, A) -> bool:
        s = sum(A)
        n = len(A)
        dp = [set() for _ in range(n//2+1)]

        p = False
        for i in range(1, n//2+1):
            if s*i%n==0:
                p = True
                break
        if not p:
            return False

        dp[0].add(0)

        for num in A:
            for i in reversed(range(1, n//2+1)):
                for t in dp[i-1]:
                    dp[i].add(t+num)
        
        for i in range(1,n//2+1):
            if (s*i%n==0 and s*i//n in dp[i]):
                return True
        return False


if __name__ == "__main__":
    print(Solution().splitArraySameAverage([2,12,18,16,19,3]))