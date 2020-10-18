package ru.mail.polis.ads;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problem solution template.
 */
public final class task2 {

    public static class Heap {
        private int[] heap;
        private int size;
        private int maxsize;

        public Heap(int maxsize) {
            this.maxsize = maxsize;
            this.size = 0;
            heap = new int[this.maxsize + 1];
            heap[0] = Integer.MAX_VALUE;
        }
        
        void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        void sink(int k) {
            while (2 * k <= size) {
                int j = 2 * k;
                if (j < size && heap[j] < heap[j + 1]) {
                    j++;
                }
                if (heap[k] >= heap[j])
                    break;
                swap(k, j);
                k = j;
            }
        }

        void swim(int k) {
            while (k > 1 && heap[k] > heap[k / 2]) {
                swap(k, k / 2);
                k = k / 2;
            }
        }

        void insert(int v) {
            heap[++size] = v;
            swim(size);
        }

        int delMax() {
            int max = heap[1];
            swap(1, size--);
            sink(1);
            return max;
        }
    }


    private static void solve(final FastScanner in, final PrintWriter out) {
        Heap my_heap = new Heap(100000);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int next_command = in.nextInt();
            if (next_command == 1) {
                out.println(my_heap.delMax());
            } else {
                int next_el = in.nextInt();
                my_heap.insert(next_el);
            }
        }
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}

