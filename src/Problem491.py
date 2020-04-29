class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        ans = []
        def find(start: int, arr: List[int]):
            s = set()
            for i in range(start, len(nums)):
                if (len(arr) == 0 or nums[i] >= arr[-1]) and nums[i] not in s:
                    s.add(nums[i])
                    arr.append(nums[i])
                    if len(arr) > 1:
                        ans.append(arr.copy())
                    find(i + 1, arr)
                    arr.pop()
        
        find(0, [])
        return ans