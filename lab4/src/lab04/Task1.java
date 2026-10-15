package lab04;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        // Дозволені комбінації аргументів (звичайні, від'ємні, нулі)
        printResults(new int[]{12, 15, 7, 25, 5, 42});
        printResults(new int[]{-10, -25, -5, 30, 0});
        printResults(new int[]{50});
        printResults(new int[]{0, 3, 7, 11});
        printResults(new int[]{-100, -15, 20, 5, 0});
        printResults(new int[]{10, 5, 20, 5, 30});

        // Заборонені комбінації аргументів (помилкові)
        printResults(new int[]{1, 2, 3, 4, 6, 7, 8, 9}); // Немає кратних 5
        printResults(new int[]{}); // Порожній масив
        printResults(null); // null масив
    }

    /**
     * Знаходить мінімальний елемент масиву, що є кратним 5.
     * Застосовано цикл «for-each».
     *
     * @param array масив цілих чисел
     * @return мінімальний елемент, що ділиться на 5 без остачі
     * @throws NullPointerException якщо масив null
     * @throws IllegalArgumentException якщо масив порожній або не містить жодного елемента, кратного 5
     */
    public static int findMinMultipleOfFive(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        boolean found = false;
        int min = Integer.MAX_VALUE;

        // Вимога: використання циклу for-each
        for (int value : array) {
            if (value % 5 == 0) {
                if (!found || value < min) {
                    min = value;
                    found = true;
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("У масиві відсутні елементи, кратні 5");
        }

        return min;
    }

    static void printResults(int[] array) {
        System.out.print("Масив: " + (array == null ? "null" : Arrays.toString(array)) + " -> ");
        try {
            int result = findMinMultipleOfFive(array);
            System.out.println("Мінімальний кратний 5: " + result);
        } catch (NullPointerException e) {
            System.out.println("EXCEPTION (NPE)! " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION (IAE)! " + e.getMessage());
        }
    }
}
