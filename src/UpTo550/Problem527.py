from typing import *

class Node:
    def __init__(self):
        self.count = 0
        self.children = {}

class Trie:
    def __init__(self):
        self.root = Node()

    def addNode(self, word):
        if len(word) < 4:
            return
        if word[0] + word[-1] + str(len(word)) not in self.root.children:
            self.root.children[word[0] + word[-1] + str(len(word))] = Node()
        cur = self.root.children[word[0] + word[-1] + str(len(word))]
        cur.count += 1
        
        for ch in word[1:-1]:
            if ch not in cur.children:
                cur.children[ch] = Node()
            cur = cur.children[ch]
            cur.count += 1
    
    def getAbbr(self, word):
        if len(word) < 4:
            return word
        cur = self.root.children[word[0] + word[-1] + str(len(word))]

        for i, ch in enumerate(word[1:]):
            if len(word) - 2 - i <= 1:
                return word
            if cur.count == 1:
                return word[:i + 1] + str(len(word) - 2 - i) + word[-1]
            if i != len(word):
                cur = cur.children[ch]

class Solution:
    def wordsAbbreviation(self, dict: List[str]) -> List[str]:
        trie = Trie()
        for word in dict:
            trie.addNode(word)

        ans = []
        
        for word in dict:
            ans.append(trie.getAbbr(word))
        
        return ans

if __name__ == "__main__":
    print(Solution().wordsAbbreviation(["abcceft","abcdefg","abccefg"]))