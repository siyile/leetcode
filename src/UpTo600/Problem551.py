from collections import Counter

class Solution:
    def checkRecord(self, s: str) -> bool:
        return Counter(s)['A'] < 2 and s.find('LLL') == -1