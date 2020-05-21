class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        cur_max = max(arrays[0])
        cur_min = min(arrays[0])
        ans = 0
        for i in range(1, len(arrays)):
            a = arrays[i]
            ans = max([ans, cur_max - min(a), max(a) - cur_min])
            cur_max = max(max(a), cur_max)
            cur_min = min(min(a), cur_min)
        return ans
