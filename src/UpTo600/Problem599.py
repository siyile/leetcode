class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        d = {}
        for i, item in enumerate(list2):
            d[item] = i
        ans = []
        idx_sum = -1
        for i, item in enumerate(list1):
            if item in d and d[item] + i >= idx_sum:
                if idx_sum == d[item] + i:
                    ans.append(item)
                else:
                    ans = [item]
                    idx_sum = d[item] + i
        return ans
                  
