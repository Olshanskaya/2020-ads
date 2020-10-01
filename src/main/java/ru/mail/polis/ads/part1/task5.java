package ru.mail.polis.ads.part1;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class task5 {


    private static class myQueue {
        ArrayList<Integer> myList = new ArrayList<>();

        void push(Integer newInt) {
            myList.add(0, newInt);
        }

        Integer pop() {
            Integer res = this.front();
            myList.remove(myList.size() - 1);
            return res;
        }

        Integer front() {
            return myList.get(myList.size() - 1);
        }

        Integer size() {
            return myList.size();
        }

        void clear() {
            myList.clear();
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        myQueue newQueue = new myQueue();
        while (true) {
            String nextLine = in.next();
            switch (nextLine) {
                case "front":
                    if (newQueue.size() == 0) {
                        out.println("error");
                        break;
                    }
                    out.println(newQueue.front());
                    break;
                case "size":
                    out.println(newQueue.size());
                    break;
                case "pop":
                    /*if (newQueue.size() == 0) {
                        out.println("error");
                        break;
                    }*/
                    out.println(newQueue.pop());
                    break;
                case "clear":
                    newQueue.clear();
                    out.println("ok");
                    break;
                case "exit":
                    out.println("bye");
                    return;
                default:
                    newQueue.push(in.nextInt());
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
