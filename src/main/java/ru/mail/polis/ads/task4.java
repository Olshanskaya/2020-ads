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
public final class task4 {


    private static void solve(final FastScanner in, final PrintWriter out) {
        String str1 = in.next();
        String str2 = in.next();
        if (str1.equals(str2)) {
            out.println("YES");
            return;
        }
        if (str1.length() == 0 && str2.length() == 0) {
            out.println("YES");
            return;
        }
        if (isTrue(str1, str2) || isTrue(str2, str1)) {
            out.println("YES");
            return;
        }
        out.println("NO");
    }


    static boolean isTrue(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        boolean[][] d = new boolean[n1 + 1][n2 + 1];
        d[0][0] = true;

        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; ++j) {
                char nextstr1 = str2.charAt(j - 1);
                char nextstr2 = str1.charAt(i - 1);
                if (nextstr1 == nextstr2 || nextstr2 == '?') {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    if (nextstr2 == '*') {
                        d[i][j] = d[i - 1][j - 1] || d[i - 1][j] || d[i][j - 1];
                    }
                }
            }
        }
        return d[str1.length()][str2.length()];
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

