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
public final class task2169 {

    private static boolean doNext(int[] mas, int n) {
        int j = n - 2;
        while (j != -1 && mas[j] >= mas[j + 1]) {
            j--;
        }
        if (j == -1) {
            return false;
        }
        int k = n - 1;
        while (mas[j] >= mas[k]) {
            k--;
        }
        int tmp = mas[j];
        mas[j] = mas[k];
        mas[k] = tmp;

        int left = j + 1;
        int right = n - 1;
        while (left < right) {
            tmp = mas[left];
            mas[left] = mas[right];
            mas[right] = tmp;
            left++;
            right--;
        }

        return true;
    }


    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            out.print(mas[i] + " ");
        }
        out.println();

        while (doNext(mas, n)) {
            for (int i = 0; i < n; i++) {
                out.print(mas[i] + " ");
            }
            out.println();
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
