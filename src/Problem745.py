from typing import Set

class TrieNode:
    def __init__(self):
        self.next = {}
        self.words: Set[str] = set()

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def add(self, word: str):
        self.root.words.add(word)
        cur = self.root
        for c in word:
            if c not in cur.next:
                cur.next[c] = TrieNode()
            cur = cur.next[c]
            cur.words.add(word)
    
    def search(self, word: str) -> Set[str]:
        cur = self.root
        for c in word:
            if c not in cur.next:
                return set()
            cur = cur.next[c]
        return cur.words

class WordFilter:

    def __init__(self, words: List[str]):
        self.pt = new Trie()
        for word in words:
            pt.add(word[:min(10, len(word))])

        self.st = new Trie()
        for word in words:
            st.add(word[::-1][min(10, len(word))])

    def f(self, prefix: str, suffix: str) -> int:
        sp = self.pt.search(prefix)
        ss = self.sp.search(suffix[::-1])

        ps = ss.intersection(sp)
        
        return max(map(self.m.get, ps)) if ps else -1
            

        


# Your WordFilter object will be instantiated and called as such:
# obj = WordFilter(words)
# param_1 = obj.f(prefix,suffix)