class MagicDictionary:

    def _can(self, w):
        for i in range(len(w)):
            yield w[:i] + '*' + w[i+1:]
        

    def buildDict(self, dictionary: List[str]) -> None:
        self.words = set(dictionary)
        self.nei = Counter(can for w in dictionary for can in self._can(w))

    def search(self, w: str) -> bool:
        return any(self.nei[can] > 1 or self.nei[can] == 1 and w not in self.words for can in self._can(w))
        


# Your MagicDictionary object will be instantiated and called as such:
# obj = MagicDictionary()
# obj.buildDict(dictionary)
# param_2 = obj.search(searchWord)