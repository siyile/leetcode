class Solution:
    def evaluate(self, expression):
        st, d, tokens = [], {}, ['']

        def get(x):
            return d.get(x, x)

        def eval(tokens):
            if tokens[0][0] != 'l':
                tmp = list(map(int, map(get, tokens[1:])))
                if tokens[0][0] == 'a':
                    return str(tmp[0]+tmp[1])
                else:
                    return str(tmp[0]*tmp[1])
            else:
                for i in range(1, len(tokens) - 1, 2):
                    if tokens[i+1]:
                        d[tokens[i]] = get(tokens[i+1])
                return get(tokens[-1])
        
        for c in expression:
            if c == '(':
                if tokens[0][0] == 'l':
                    eval(tokens)
                st.append((dict(d), tokens))
                tokens = ['']
            elif c == ')':
                val = eval(tokens)
                d, tokens = st.pop()
                tokens[-1] += val
            elif c == ' ':
                tokens.append('')
            else:
                tokens[-1] += c
        
        return int(tokens[-1])

if __name__ == "__main__":
    print(Solution().evaluate('let x 1 y 2 x (add x y) (add x y)'))