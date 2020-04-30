class Solution:
    def reversePairs(self, nums: List[int]) -> int:

        n: int = len(nums)

        def merge(start: int, end: int, mid: int) -> int:
            cnt = 0
            if start + 1 == end:
                return

            i, j = start, mid
            nums_small = 0

            while i < mid and j < end:
                if nums[i] > nums[j] * 2:
                    j += 1
                    nums_small += 1
                else:
                    cnt += nums_small
                    i += 1
            
            while i < mid:
                i += 1
                cnt += nums_small

            arr = nums[start:end]
            arr.sort()
            nums[start:end] = arr
            
            return cnt


        def mergeSort(start: int, end: int) -> int:
            if end <= start + 1:
                return 0
            
            mid = (end + start) // 2

            return mergeSort(start, mid) + mergeSort(mid, end) + merge(start, end, mid)

        return mergeSort(0, n)