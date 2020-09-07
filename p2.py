'''
N * N 
A B C D

input: N, A, B, C, D, A+B+C+D = N*N
ouput: integer

input: 2 3 1 0 0
output: 4

input: 2 2 1 1 0
output: 12

N <= 10

3 A 1 B

A -> D
bt loop 4

A
B A A A  
time O(4^n)
'''

def numOfWay(N, A, B, C, D) -> int:
    count = [A, B, C, D]
    N *= N

    def bt(start):
        if start == N:
            return 1
        ans = 0
        # A -> D
        for i, c in enumerate(count):
            if c > 0:
                count[i] -= 1
                ans += bt(start + 1)
                count[i] += 1
        return ans
    
    return bt(0)


print(numOfWay(2,2,1,1,0))


'''
        1
    2       3
4       5 6     7

func numOfTree()
func delete()

delete(1)
    if i have 2 children: return (delete(3) + delete(2) + 1)

numOfTree()


public int findForest(Node root) {
    if(root == null)
        return 0;

    if(root.left == null && root.right == null)
        return 1;

    if(isLeaf(root.left) && isLeaf(root.right))
        return 1;

    int left = findForest(root.left), right = findForest(root.right);

    return left+right;
}



    3
 6      7

 path x node have two children
 if x > 1:
     ans += x
else:
    do nothing
 
2 + 0 



'''

