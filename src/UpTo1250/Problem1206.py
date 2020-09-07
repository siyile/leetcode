class Node:
    def __init__(self, val, level):
        self.val = val
        self.levels = [None] * level


class Skiplist:

    def __init__(self):
        self.head = Node(-1, 16)

    def __iter(self, num):
        cur = self.head
        for level in range(15, -1, -1):
            while True:
                future = cur.levels[level]
                if future and future.val < num:
                    cur = future
                else:
                    break
            yield cur, level

    def search(self, target: int) -> bool:
        for prev, level in self.__iter(target):
            pass
        cur = prev.levels[0]
        return cur and cur.val == target
        

    def add(self, num: int) -> None:
        nodelvls = min(16, 1 + int(math.log2(1.0 / random.random())))
        node = Node(num, nodelvls)

        for cur, level in self.__iter(num):
            if level < nodelvls:
                future = cur.levels[level]
                cur.levels[level] = node
                node.levels[level] = future

    def erase(self, num: int) -> bool:
        ans = False
        for cur, level in self.__iter(num):
            future = cur.levels[level]
            if future and future.val == num:
                ans = True
                cur.levels[level] = future.levels[level]
        return ans