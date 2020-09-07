from collections import defaultdict

class Solution:
  def minJumps(self, arr: List[int]) -> int:
    m = defaultdict(set)
    for i, x in enumerate(arr):
        m[x].add(i)

    q = collections.deque([0])
    step = 0
    while q:
      print(q)
      for _ in range(len(q)):
        cur = q.popleft()
        if cur == len(arr) - 1:
          return step
        for nei in m[arr[cur]]:
          m[arr[cur]].remove(cur)
          q.append(nei)
        for nei in [cur-1,cur+1]:
          if nei > 0 and nei < len(arr) and nei in m[arr[nei]]:
            m[arr[nei]].remove(nei)
            q.append(nei)
            
      step += 1
    
        