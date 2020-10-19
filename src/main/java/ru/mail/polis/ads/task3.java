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

    private static void solve(final FastScanner in, final PrintWriter out) throws IOException {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        String next;
        int size = 1;
        int mediana = -1;


        while ((next = in.reader.readLine()) != null) {
            int nextInt = Integer.parseInt(next);
            if (size % 2 != 0) {
                if (nextInt > mediana) {
                    minHeap.add(nextInt);
                    mediana = minHeap.poll();
                } else {
                    maxHeap.add(nextInt);
                    mediana = maxHeap.poll();
                }
            } else {
                if (nextInt > mediana) {
                    minHeap.add(nextInt);
                    maxHeap.add(mediana);
                } else {
                    maxHeap.add(nextInt);
                    minHeap.add(mediana);
                }
                mediana = (minHeap.peek() + maxHeap.peek()) / 2;
            }
            size++;
            out.write(mediana + "\n");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

