import re
class StringIterator(object):
    def __init__(self, compressedString):
        self.tokens = []
        for token in re.findall('\D\d+', compressedString):
            self.tokens.append((token[0], int(token[1:])))
        self.tokens = self.tokens[::-1]

    def next(self):
        if not self.tokens: return ' '
        t, n = self.tokens.pop()
        if n > 1: 
            self.tokens.append((t, n - 1))
        return t

    def hasNext(self):
        return bool(self.tokens)