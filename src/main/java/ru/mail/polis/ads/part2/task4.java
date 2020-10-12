package ru.mail.polis.ads.part2;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.math.BigInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class task4 {

    public static BigInteger findElement(BigInteger[] arr, int k, int size) {
        int left = 0, right = size;
        while (true) {
            int mid = partition(arr, left, right);
            if (mid == k) {
                return arr[mid];
            }
            if (k < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
    }

    private static int partition(BigInteger[] arr, int left, int right) {
        int j = left;
        BigInteger x = arr[left];
        for (int i = left + 1; i < right; i++) {
            if (arr[i].compareTo(x) > 0) {
                j++;
                BigInteger temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        BigInteger temp = arr[j];
        arr[j] = arr[left];
        arr[left] = temp;
        return j;
    }


    private static void solve(final FastScanner in, final PrintWriter out) throws IOException {

        int findEl = in.nextInt() - 1;
        ArrayList<BigInteger> mas = new ArrayList<BigInteger>();
        int size = 0;
        String nextLine = in.reader.readLine();
        ArrayList<String> inputList = new ArrayList<String>(Arrays.asList(nextLine.split(" ")));
        for (String item : inputList) {
            BigInteger temp = new BigInteger(item);
            mas.add(temp);
            size += 1;
        }
        BigInteger[] arr = mas.toArray(new BigInteger[0]);
        out.println(findElement(arr, findEl, size));
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
