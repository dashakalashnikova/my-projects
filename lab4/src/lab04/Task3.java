package lab04;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
        // Дозволені комбінації аргументів
        printResults(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7});
        printResults(new int[]{10}, new int[]{20});
        printResults(new int[]{}, new int[]{1, 2, 3});
        printResults(new int[]{9, 8, 7}, new int[]{});
        printResults(new int[]{}, new int[]{});
        printResults(new int[]{-5, 0, 5}, new int[]{15, -20});

        // Заборонені комбінації аргументів (null)
        printResults(null, new int[]{1, 2});
        printResults(new int[]{1, 2}, null);
        printResults(null, null);
    }

    /**
     * Формує масив C(n+m), що містить n елементів масиву A,
     * за якими слідують m елементів масиву B.
     *
     * @param a перший масив A розмірності n
     * @param b другий масив B розмірності m
     * @return новий масив C розмірності n + m
     * @throws NullPointerException якщо хоча б один із масивів є null
     */
    public static int[] concatenateArrays(int[] a, int[] b) {
        if (a == null) {
            throw new NullPointerException("Масив A не може бути null");
        }
        if (b == null) {
            throw new NullPointerException("Масив B не може бути null");
        }

        int[] c = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }

        for (int j = 0; j < b.length; j++) {
            c[a.length + j] = b[j];
        }

        return c;
    }

    static void printResults(int[] a, int[] b) {
        System.out.print("A: " + (a == null ? "null" : Arrays.toString(a)) + ", ");
        System.out.print("B: " + (b == null ? "null" : Arrays.toString(b)) + " -> ");
        try {
            int[] result = concatenateArrays(a, b);
            System.out.println("C: " + Arrays.toString(result));
        } catch (NullPointerException e) {
            System.out.println("EXCEPTION (NPE)! " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION (IAE)! " + e.getMessage());
        }
    }
}
