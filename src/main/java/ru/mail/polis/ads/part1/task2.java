package ru.mail.polis.ads.part1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class task2 {
    public static void str_str(String first, final PrintWriter out) {
        Stack<String> stack_first = new Stack<>();
        for (int i = 0; i < first.length(); i++) {
            char next_char = first.charAt(i);
            if (Character.isUpperCase(next_char)) {
                String a = stack_first.pop();
                String b = stack_first.pop();
                String res = "(" + a + next_char + b + ")";
                stack_first.push(res);
            } else {
                stack_first.push(Character.toString(next_char));
            }
        }
        String second = stack_first.pop();

        /*ArrayDeque<String> deq = new ArrayDeque<String>();
        for (int i = 0; i < second.length(); i++) {
            char next_char = second.charAt(i);
            if(Character.isUpperCase(next_char)){
                String a = deq.pop();
                String b = deq.pop();
                String res = a + next_char + b;
                deq.add(res);
            }
            else {
                deq.add(Character.toString(next_char));
            }
        }
        System.out.println(deq.pop());*/

        ArrayDeque<String> deq = new ArrayDeque<String>();
        deq.add(second);
        String rez = new String();
        while (!deq.isEmpty()) {
            String next_vir = deq.pop();
            if (next_vir.charAt(0) == '(') {
                int j = 0;
                for (int i = 1; i < second.length(); i++) {
                    char next_char = next_vir.charAt(i);
                    if (next_char == '(') {
                        j++;
                    }
                    if (next_char == ')') {
                        j--;
                    }
                    if (j == 0 && Character.isUpperCase(next_char)) {
                        rez = next_char + rez;
                        deq.add(next_vir.substring(i + 1, next_vir.length() - 1));
                        deq.add(next_vir.substring(1, i));
                        break;
                    }
                }
            } else {
                rez = next_vir + rez;
            }
        }
        out.print(rez);
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int i = in.nextInt();
        for (int j = 0; j < i; j++) {
            String str = in.nextLine();
            str_str(str, out);
            out.print("\n");
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

        String nextLine() {
            return next();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {
            solve(in, out);
        }
    }
}
