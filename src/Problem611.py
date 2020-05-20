class Solution:
    def triangleNumber(self, nums) -> int:
        nums.sort()
        n = len(nums)
        cnt = 0
        for k in range(n - 1, 1, -1):
            i = 0
            j = k - 1
            while i < j:
                if nums[i] + nums[j] > nums[k]:
                    cnt += j - i
                    j -= 1
                else:
                    i += 1
        return cnt

if __name__ == "__main__":
    print(Solution().triangleNumber([1,1,3,4]))
    print(Solution().triangleNumber([2,2,3,4]))
    print(Solution().triangleNumber([0,0,0]))
