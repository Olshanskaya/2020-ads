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
public final class task4 {

    private static int dinamic(int index, int[] dnbool, int[] dn,int[] mas, int n, int k) {
        if (index >= 2 * n) {
            return 0;
        }
        if (dnbool[index] == 1) {
            return dn[index];
        }
        int tmpmin = dinamic(index + 1, dnbool, dn, mas, n, k);
        for (int i = 2; i <= k; i++) {
            tmpmin = Math.max(tmpmin, dinamic(index + i,  dnbool, dn, mas, n, k));
        }
        dnbool[index] = 1;
        return dn[index] = mas[index] + tmpmin;
    }


    private static void solve(final FastScanner in, final PrintWriter out) {
        int[] dnbool = new int[2000];
        int[] dn = new int[2000];
        int n = in.nextInt();
        int[] mas = new int[2 * n + 2];

        for (int i = 0; i < 2 * n + 2; i++) {
            mas[i] = 0;
        }
        for (int i = 0; i < 2000; i++) {
            dnbool[i] = 0;
            dn[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            mas[i] = in.nextInt();
        }
        int k = in.nextInt();
        int ans = dinamic(0, dnbool, dn, mas, n, k);
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