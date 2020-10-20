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
        int m = in.nextInt();


        int[][] mas = new int[n][m];
        int[][] way = new int[n][m];
        char[][] char_way = new char[n][m];

        //в ячеке будет стоять та буковка, каким способом сюда пришли
        String str_way = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = in.nextInt();
                mas[n - i - 1][j] = tmp;
                way[n - i - 1][j] = tmp;
                char_way[i][j] = 'x';
            }
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(mas[i][j]);
            }
            out.println();
        }*/


        for (int i = 1; i < n; i++) {
            char_way[i][0] = 'F';
        }
        for (int j = 1; j < m; j++) {
            char_way[0][j] = 'R';
        }
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(char_way[i][j]);
            }
            out.println();
        }*/


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int zern;
                char dir;

                if (mas[i][j - 1] > mas[i - 1][j]) {
                    dir = 'F';
                    zern = mas[i][j - 1];
                } else {
                    dir = 'R';
                    zern = mas[i - 1][j];
                }
                char_way[i][j] = dir;
                mas[i][j] += zern;
            }
        }
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(char_way[i][j]);
            }
            out.println();
        }*/

        int i = n - 1;
        int j = m - 1;
        while (true) {
            str_way += char_way[i][j];
            if(char_way[i][j] == 'F') {
                i -= 1;
            } else {
                j -= 1;
            }
            if(i == 0 && j == 0) {
                break;
            }
        }
        out.println(str_way);
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