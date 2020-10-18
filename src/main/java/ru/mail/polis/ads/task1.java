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
public final class task1 {


    private static int isItHeap(long[] mas, int n, final PrintWriter out) {
        for (int i = 1; i <= n / 2 + 1; i++) {
            if (2 * i < n) {
                if (mas[i] > mas[2 * i]) {
                    return 0;
                }
            }
            if (2 * i + 1 < n) {
                if (mas[i] > mas[2 * i] + 1) {
                    return 0;
                }
            }

        }
        return 1;

    }


    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        long[] mas = new long[n + 1];
        mas[0] = 0;
        for (int i = 1; i <= n; i++) {
            long nextEl = Long.valueOf(in.next()).longValue();
            mas[i] = nextEl;
        }
        int rez = isItHeap(mas, n, out);
        if (rez == 0) {
            out.println("NO");
        } else {
            out.println("YES");
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
