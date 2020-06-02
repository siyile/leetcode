class Solution:
    def getProbability(self, balls: List[int]) -> float:
        self.all = 0
        self.good = 0
        self.sum = sum(balls)
        left = {}
        right = {}
        from math import factorial
        p = lambda n, x: factorial(n) / reduce(operator.mul, [factorial(i) for i in x.values()])
        def dfs(i, sum1, sum2, color1, color2):
            if abs(sum1 - sum2) > self.sum - sum1 - sum2:
                return
            if i == len(balls):
                if sum1 != sum2:
                    return
                p1, p2 = p(sum1, left), p(sum2, right)
                self.all += p1 * p2
                self.good += p1 * p2 * (color1 == color2)
            else:
                for j in range(balls[i] + 1):
                    left[i], right[i] = j, balls[i] - j
                    dfs(i+1, sum1+j, sum2+balls[i]-j, color1+(j!=0), color2+(balls[i]!=j))
        dfs(0,0,0,0,0)
        return self.good/self.all

