package ru.mail.polis.ads.part2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class task2 {

    private static void solve(final FastScanner in, final PrintWriter out) {
        int size = in.nextInt();
        Integer[] mas = new Integer[size];
        for (int j = 0; j < size; j++) {
            int nextInt = in.nextInt();
            mas[j] = nextInt;
        }
        Arrays.sort(mas, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                Integer q1 = 0;
                Integer q2 = 0;
                if (o1 < 10) {
                    q1 = o1 * 10;
                }
                if (o1 > 10 && o1 < 100) {
                    q1 = o1 / 10 + 10 * (o1 % 10);
                }
                if (o2 < 10) {
                    q2 = o2 * 10;
                }
                if (o2 > 10 && o2 < 100) {
                    q2 = o2 / 10 + 10 * (o2 % 10);
                }
                return q1.compareTo(q2);
            }
        });
        for (Integer e : mas) {
            out.print(e + " ");
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
