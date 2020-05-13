class Solution:
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if not nums:
            return []
        #newnums = sorted(list(set(nums)),reverse=True)
        #all the scores of athletes are guaranteed to be unique
        newnums = sorted(nums,reverse = True)
        dic = {}
        l = len(newnums)
        dic[newnums[0]] = "Gold Medal"
        if l>1:
            dic[newnums[1]] = "Silver Medal"
        if l>2:
            dic[newnums[2]] = "Bronze Medal"      
        for i in range(3,len(newnums)):
            dic[newnums[i]] = str(i+1)
        res = [dic[k] for k in nums]
        return res