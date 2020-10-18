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

    private static boolean binSeach(int[] mas, int size, int el) {
        int left = size - 1;
        int right = 0;
        while (left >= right) {
            int med = (right + left) / 2;
            if (mas[med] == el) {
                return true;
            }
            if (mas[med] < el) {
                right = med + 1;
            } else {
                left = med - 1;
            }
        }
        /*for (int i = 0; i< size; i++) {
            if(mas[i] == el) {
                return true;
            }
        }*/
        return false;
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int size = in.nextInt();
        int n = in.nextInt();
        int[] mas = new int[size];
        for (int i = 0; i < size; i++) {
            mas[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int element = in.nextInt();
            boolean rez = binSeach(mas, size, element);
            if (rez) {
                out.println("YES");
            } else {
                out.println("NO");
            }
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

