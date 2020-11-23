class Solution:
    def totalFruit(self, tree: List[int]) -> int:
        k = 0
        left = 0
        ans = 0
        n = len(tree)
        cnt = defaultdict(int)
        for right in range(n):
            cnt[tree[right]] += 1
            if cnt[tree[right]] == 1:
                k += 1
            while k > 2:
                cnt[tree[left]] -= 1
                if cnt[tree[left]] == 0:
                    k -= 1
                left += 1
            ans = max(ans, right - left + 1)
        return ans
             