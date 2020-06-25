class Solution:
    def threeEqualParts(self, A: List[int]) -> List[int]:
        from collections import Counter
        counter = Counter(A)
        c = counter[1]
        if c == 0:
            return [0, 2]
        if c % 3 != 0:
            return [-1, -1]
        
        k = 0
        c //= 3
        n = len(A)
        for i in range(n):
            if A[i] == 1:
                k += 1
                start = i
                break
        
        for i in range(start+1, n):
            if A[i] == 1:
                k += 1
                if k == c + 1:
                    mid = i
                    break
        
        for i in range(mid+1, n):
            if A[i] == 1:
                k += 1
                if k == 2 * c + 1:
                    end = i
                    break
        
        while end < n and A[start] == A[mid] and A[mid] == A[end]:
            end += 1
            mid += 1
            start += 1
        
        if end == n:
            return [start-1, mid]
        else:
            return [-1, -1]