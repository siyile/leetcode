package UpTo350;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem313 {
    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] idx = new int[primes.length];
        int[] ugly = new int[n];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);
        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (val[j] == ugly[i]) val[j] = primes[j] * ugly[idx[j]++];
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        Queue<Prime> q = new PriorityQueue<>();
        for (int prime :
                primes) {
            q.add(new Prime(1, prime, prime));
        }

        for (int i = 1; i < n; i++) {
            ugly[i] = q.peek().val;
            while (ugly[i] == q.peek().val) {
                Prime prime = q.poll();
                q.add(new Prime(prime.idx + 1, ugly[prime.idx] * prime.p, prime.p));
            }
        }
        return ugly[n - 1];
    }

    class Prime implements Comparable<Prime> {
        int idx;
        int val;
        int p;

        public Prime(int idx, int val, int p) {
            this.idx = idx;
            this.val = val;
            this.p = p;
        }

        @Override
        public int compareTo(Prime o) {
            return val - o.val;
        }
    }
}
