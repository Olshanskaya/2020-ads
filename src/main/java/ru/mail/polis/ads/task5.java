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
public final class task5 {

    private static int merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int count = 0;
        int nl = left.length;
        int nr = right.length;
        while (i < nl || j < nr) {
            if (i == nl) {
                arr[i + j] = right[j];
                j++;
            } else {
                if (j == nr) {
                    arr[i + j] = left[i];
                    i++;
                } else {
                    if (left[i] <= right[j]) {
                        arr[i + j] = left[i];
                        i++;
                    } else {
                        arr[i + j] = right[j];
                        count += nl - i;
                        j++;
                    }
                }
            }
        }
        return count;
    }

    private static int invCount(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return 0;

        int m = (n + 1) / 2;

        int left[] = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = arr[i];
        }
        int right[] = new int[n - m];
        for (int i = m; i < n; i++) {
            right[i - m] = arr[i];
        }

        return invCount(left) + invCount(right) + merge(arr, left, right);
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int mas[] = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = in.nextInt();
        }
        int ans = invCount(mas);
        out.println(ans);

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