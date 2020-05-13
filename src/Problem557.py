class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(map(lambda x:x[::-1], s.split(" ")))