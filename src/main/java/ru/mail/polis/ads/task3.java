package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.lang.Math.*;

/**
 * Problem solution template.
 */
public final class task3 {

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n1 = in.nextInt();
        int[] mas1 = new int[n1 + 1];
        for (int i = 1; i <= n1; i++) {
            mas1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] mas2 = new int[n2 + 1];
        for (int i = 1; i <= n2; i++) {
            mas2[i] = in.nextInt();
        }

        int size = Math.max(n1, n2);
        int[][] mas = new int[2][size + 1];
        for (int i = 0; i < size + 1; i++) {
            mas[0][i] = 0;
            mas[1][i] = 0;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (mas1[i] == mas2[j]) {
                    mas[i % 2][j] = 1 + mas[(i + 1) % 2][j - 1];
                } else {
                    mas[i % 2][j] = Math.max(mas[(i + 1) % 2][j], mas[i % 2][j - 1]);
                }

            }
        }
        out.println(mas[n1 % 2][n2]);

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