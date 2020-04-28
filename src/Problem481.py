class Solution:
    def magicalString(self, n: int) -> int: 
        arr = [1, 2, 2]
        i = 2
        turn = 1

        while len(arr) < n:
            for _ in range(arr[i]):
                arr.append(turn)
            turn = 1 if turn == 2 else 2
            i += 1
        
        return sum(map(lambda x: 1 if x == 1 else 0, arr[:n]))


if __name__ == "__main__":
    print(Solution().magicalString(100))