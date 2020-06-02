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