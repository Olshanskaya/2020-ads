package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

public class task3 {
    /*public static class MAxHeap {
        private int[] heap;
        private int size;
        private int maxsize;

        public MAxHeap(int maxsize) {
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
    }*/


    /*private static void solve(final task3.FastScanner in, final PrintWriter out) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        Integer mediana = -1;

        while (true) {

            String next = in.next();
            int nextEl = Integer.parseInt(next);
            if (nextEl > mediana) {
                if(minHeap.size() <= maxHeap.size()) {
                    minHeap.add(nextEl);
                } else {
                    Integer el = minHeap.peek();
                    minHeap.remove();
                    minHeap.add(nextEl);
                    maxHeap.add(el);
                }

            } else {
                if(maxHeap.size() < minHeap.size()) {
                    minHeap.add(nextEl);
                } else {
                    Integer el = maxHeap.peek();
                    maxHeap.remove();
                    maxHeap.add(nextEl);
                    minHeap.add(el);
                }
            }
            if (maxHeap.size() == minHeap.size()) {
                Integer maxFromMinHEap = maxHeap.peek();
                Integer minFromMaxHeap = minHeap.peek();
                mediana = (maxFromMinHEap + minFromMaxHeap) / 2;
            } else {
                if (maxHeap.size() > minHeap.size()) {
                    mediana = maxHeap.peek();
                } else {
                    mediana = minHeap.peek();
                }
            }
            out.println(mediana);
        }
    }*/


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
            int n = in.nextInt();
            out.println(in.nextInt());
            //solve(in, out);
        } catch (Exception ex) {

        }
    }
}
