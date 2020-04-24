class Solution:
    def getMaxRepetitions(self, s1: str, n1: int, s2: str, n2: int) -> int:
        k_count = {}
        next_index = {}

        k_count[0] = 0
        next_index[0] = 0

        j, cnt = 0, 0

        for k in range(1, n1 + 1):
            for i in range(len(s1)):
                if s1[i] == s2[j]:
                    j += 1
                    if j == len(s2):
                        j = 0
                        cnt += 1
            
            if j in next_index:
                start = next_index[j]
                prefix_count = k_count[start]
                pattern_count = (n1 - start) // (k - start) * (cnt - prefix_count)
                suffix_count = k_count[start + (n1 - start) % (k - start)] - prefix_count
                return (prefix_count + pattern_count + suffix_count) // n2
            
            k_count[k] = cnt
            next_index[j] = k
        
    
        return k_count[n1] // n2