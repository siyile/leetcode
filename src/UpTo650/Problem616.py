class Node:
    def __init__(self):
        self.word = set()
        self.next = {}

class Trie:
    def __init__(self):
        self.root = Node()

    def add(self, s):
        node = self.root
        for c in s:
            if c not in node.next:
                node.next[c] = Node()
            node = node.next[c]
        node.word.add(s)

    def search(self, s, i):
        node = self.root
        j = i
        res = -1
        while j < len(s) and s[j] in node.next:
            node = node.next[s[j]]
            if node.word:
                res = j
            j += 1
        return res

class Solution:
    def addBoldTag(self, s: str, dict: List[str]) -> str:
        trie = Trie()
        for word in dict:
            trie.add(word)

        A = [False for _ in range(len(s))]
        
        for i in range(len(s)):
            j = trie.search(s, i)
            if j != -1:
                A[i:j+1] = [True] * (j + 1 - i)
        
        ans = ''
        l = -1
        for i, a in enumerate(A):
            if not a:
                ans += s[i]
                continue
            if a and l == -1:
                l = i
            if a and (i+1 == len(A) or not A[i+1]):
                ans += '<b>' + s[l:i+1] + '</b>'
                l = -1
        return ans

        

