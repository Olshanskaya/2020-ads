package ru.mail.polis.ads.part1;

import java.io.*;
import java.util.StringTokenizer;

public class task3 {
    private static void solve(final FastScanner in, final PrintWriter out) {
        String str = in.nextLine();
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            char next_char = str.charAt(i);
            if (next_char == '(')
                flag++;
            else
                flag--;
            if (flag < 0) {
                System.out.print("NO");
                return;
            }
        }
        if (flag != 0) {
            System.out.print("NO");
            return;
        }
        System.out.print("YES");
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

        String nextLine() {
            return next();
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
