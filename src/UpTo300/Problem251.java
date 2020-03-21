package UpTo300;

import java.util.Iterator;

public class Problem251 {
    private class Vector2D {
        int i;
        int j;
        int[][] v;

        public Vector2D(int[][] v) {
            this.v = v;
            i = 0;
            j = 0;
        }

        public int next() {
            if (hasNext()) return v[i][j++];
            else return -1;
        }

        public boolean hasNext() {
            while (i < v.length && j == v[i].length) {
                j = 0;
                i++;
            }
            return i < v.length;
        }
    }
}
