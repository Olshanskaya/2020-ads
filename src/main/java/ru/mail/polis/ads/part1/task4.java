package ru.mail.polis.ads.part1;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class task4 {

    private static class myStack {
        ArrayList<Integer> myList = new ArrayList<>();
        void push (Integer newInt) {
            myList.add(newInt);
        }
        Integer pop () {
            Integer res = this.back();
            myList.remove(myList.size() - 1);
            return res;
        }
        Integer back () {
            return myList.get(myList.size() - 1);
        }
        Integer size () {
            return myList.size();
        }
        void clear () {
            myList.clear();
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        myStack newStack = new myStack();
        while (true) {
            String nextLine = in.next();
            switch (nextLine) {
                case "back":
                    if(newStack.size() == 0) {
                        out.println("error");
                        break;
                    }
                    out.println(newStack.back());
                    break;
                case "size":
                    out.println(newStack.size());
                    break;
                case "pop":
                    if(newStack.size() == 0) {
                        out.println("error");
                        break;
                    }
                    out.println(newStack.pop());
                    break;
                case "clear":
                    newStack.clear();
                    out.println("ok");
                    break;
                case "exit":
                    out.println("bye");
                    return;
                default:
                    newStack.push(in.nextInt());
                    out.println("ok");
                    break;
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
