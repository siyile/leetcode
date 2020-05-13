class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        upper = False
        lower = False
        for i in range(len(word) - 1, 0, -1):
            if word[i].isupper():
                upper = True
            if word[i].islower():
                lower = True
        
        return (word[0].isupper() and not (lower and upper)) or (word[0].islower() and not upper)