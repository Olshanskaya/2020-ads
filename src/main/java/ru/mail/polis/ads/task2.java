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


    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int[] mas = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (mas[j] != 0) {
                    if (mas[i] % mas[j] == 0 && d[j] + 1 > d[i]) {
                        d[i] = d[j] + 1;
                    }
                }
            }
        }
        int max = d[0];
        for (int i = 1; i < n; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        out.println(max);


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
