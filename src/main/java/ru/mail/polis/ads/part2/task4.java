package ru.mail.polis.ads.part2;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class task4 {

    private static int partition(ArrayList<Integer> arr, int l, int r) {
        int x = arr.indexOf(r), i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr.indexOf(j) <= x) {
                // Swapping arr[i] and arr[j]
                int temp = arr.indexOf(i);
                arr.add(i, arr.indexOf(j));
                arr.add(j, temp);
                i++;
            }
        }
        // Swapping arr[i] and arr[r]
        int temp = arr.indexOf(i);
        arr.add(i, arr.indexOf(r));
        arr.add(r, temp);
        //arr[r] = temp;
        return i;
    }

    private static int findOrderStatistic(ArrayList<Integer> array, int k, int size) {
        int left = 0, right = size;
        while (true) {
            int mid = partition(array, left, right);
            if (mid == k) {
                return array.indexOf(mid);
            } else if (k < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
    }


    private static void solve(final FastScanner in, final PrintWriter out) throws IOException {

        int findEl = in.nextInt();
        ArrayList<Integer> mas = new ArrayList<Integer>();
        int size = 0;
        String nextLine = in.reader.readLine();
        ArrayList<String> inputList = new ArrayList<String>(Arrays.asList(nextLine.split(" ")));
        for (String item : inputList) {
            mas.add(Integer.valueOf(item));
            size += 1;
        }

        int orderStatistic = findOrderStatistic(mas, findEl, size);

        out.println(mas.indexOf(orderStatistic));

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
