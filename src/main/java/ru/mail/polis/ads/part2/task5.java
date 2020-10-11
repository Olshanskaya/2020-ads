package ru.mail.polis.ads.part2;


import java.io.*;
import java.util.StringTokenizer;


public class task5 {


    public static void merge(int[] array, int left, int mid, int right, int[] second) {

        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;
        int leftArray[] = new int[sizeLeft];
        int rightArray[] = new int[sizeRight];
        int leftArray_second[] = new int[sizeLeft];
        int rightArray_second[] = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            leftArray[i] = array[left + i];
            leftArray_second[i] = second[left + i];
        }
        for (int i = 0; i < sizeRight; i++) {
            rightArray[i] = array[mid + i + 1];
            rightArray_second[i] = second[mid + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < sizeLeft && rightIndex < sizeRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    second[i] = leftArray_second[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    second[i] = rightArray_second[rightIndex];
                    rightIndex++;
                }
            } else {
                if (leftIndex < sizeLeft) {
                    array[i] = leftArray[leftIndex];
                    second[i] = leftArray_second[leftIndex];
                    leftIndex++;
                } else {
                    if (rightIndex < sizeRight) {
                        array[i] = rightArray[rightIndex];
                        second[i] = rightArray_second[rightIndex];
                        rightIndex++;
                    }
                }
            }

        }
    }

    private static void mergeSort(int[] arr, int left, int right, int[] second) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, second);
        mergeSort(arr, mid + 1, right, second);
        merge(arr, left, mid, right, second);
    }

    private static void solve(final FastScanner in, final PrintWriter out) {

        int size = in.nextInt();
        int masFirst[] = new int[size];
        int masSecond[] = new int[size];
        for (int i = 0; i < size; i++) {
            masFirst[size - i - 1] = in.nextInt();
            masSecond[size - i - 1] = in.nextInt();
        }
        mergeSort(masFirst, 0, size - 1, masSecond);
        for (int i = 0; i < size; i++) {
            out.println(masFirst[i] + " " + masSecond[i]);
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
