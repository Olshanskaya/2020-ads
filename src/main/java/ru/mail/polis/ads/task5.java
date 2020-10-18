package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

public class task5 {
    private static boolean isItTrue(int[] mas, int n, int var, int k) {
        int last = mas[0];
        k--;
        for (int i = 1; i < n; i++) {
            if((mas[i] - last) >= var) {
                last = mas[i];
                k--;
            }
        }
        if (k <= 0) {
            return true;
        }
        return false;
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < n; i ++) {
            mas[i] = in.nextInt();
        }
        int left = 0;
        int right = mas[n-1] - mas[0] + 1;
        while(right - left > 1) {
            int mid = (left + right) / 2;
            if (isItTrue(mas, n, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        out.println(left);
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