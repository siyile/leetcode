class Solution:
    def largestPalindrome(self, n: int) -> int:
        maxNum = 10 ** n - 1
        minNum = maxNum // 10

        for h in range(maxNum, minNum, -1):
            left = h
            right = 0
            i = h
            while i > 0:
                right = right * 10 + i % 10
                i //= 10
                left *= 10
            
            palindrom = left + right

            for i in range(maxNum, minNum, -1):
                j = palindrom // i
                if j > i:
                    break
                if palindrom % i == 0:
                    return palindrom % 1337
        
        return 9

if __name__ == "__main__":
    print(Solution().largestPalindrome(1))