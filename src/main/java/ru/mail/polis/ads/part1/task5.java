package ru.mail.polis.ads.part1;

import java.io.*;
import java.util.StringTokenizer;

public class task5 {
    private static class node {
        node next;
        node last;
        Integer element;

        node(node prev, node sled, Integer newVal) {
            this.next = sled;
            this.last = prev;
            this.element = newVal;
        }

        void setNext(node newVal) {
            this.next = newVal;
        }

        Integer getElement() {
            return element;
        }

        node getPrev() {
            return last;
        }
    }

    private static class myQueue {
        node head;
        node tail;
        Integer queueSize = 0;

        void push(Integer newInt) {
            if (queueSize == 0) {
                node n = new node(null, null, newInt);
                tail = n;
                head = n;
            } else {
                node n = new node(null, tail, newInt);
                tail.setNext(n);
                tail = n;
            }
            queueSize++;
        }

        Integer pop() {
            Integer res = head.getElement();
            head = head.getPrev();
            queueSize--;
            return res;
        }

        Integer front() {
            return head.getElement();
        }

        Integer size() {
            return queueSize;
        }

        void clear() {
            head = null;
            tail = null;
            queueSize = 0;
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        myQueue newStack = new myQueue();
        while (true) {
            String nextLine = in.next();
            switch (nextLine) {
                case "front":
                    if (newStack.size() == 0) {
                        out.println("error");
                        break;
                    }
                    out.println(newStack.front());
                    break;
                case "size":
                    out.println(newStack.size());
                    break;
                case "pop":
                    if (newStack.size() == 0) {
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
