class Solution:
    def crackSafe(self, n: int, k: int) -> str:
        pwd = '0' * (n - 1)
        v = set()
        D = '9876543210'[-k:]
        for _ in range(k**n):
            for d in D:
                c = (pwd[-n+1:] if n > 1 else '')  + str(d) 
                if c not in v:
                    pwd += str(d)
                    v.add(c)
                    break
        return pwd

if __name__ == "__main__":
    print(Solution().crackSafe(1,2))