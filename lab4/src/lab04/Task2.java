package lab04;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        // Дозволені комбінації аргументів
        printResults(new int[]{10, 3, 25, 7, 1});
        printResults(new int[]{42});
        printResults(new int[]{5, -2, 10, 8, -2});
        printResults(new int[]{7, 7, 7, 7});
        printResults(new int[]{-10, 20, 0, -30, 40});
        printResults(new int[]{100, 2, 3, 4, 5});

        // Заборонені комбінації аргументів
        printResults(new int[]{}); // Порожній масив
        printResults(null);        // null
    }

    /**
     * Обчислює середнє геометричне порядкових номерів (1-based index)
     * максимального та мінімального елементів масиву: sqrt(pos_min * pos_max).
     * Застосовано цикл «for».
     *
     * @param array масив цілих чисел
     * @return середнє геометричне порядкових номерів
     * @throws NullPointerException якщо масив null
     * @throws IllegalArgumentException якщо масив порожній
     */
    public static double calculateGeometricMeanOfMinMaxPositions(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int minIndex = 0;
        int maxIndex = 0;

        // Вимога: обов'язкове використання циклу for
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }

        // Порядкові номери (1-based: перший елемент має номер 1)
        int minNumber = minIndex + 1;
        int maxNumber = maxIndex + 1;

        return Math.sqrt((double) minNumber * maxNumber);
    }

    static void printResults(int[] array) {
        System.out.print("Масив: " + (array == null ? "null" : Arrays.toString(array)) + " -> ");
        try {
            double result = calculateGeometricMeanOfMinMaxPositions(array);
            System.out.println("Сер. геом. номерів min/max: " + result);
        } catch (NullPointerException e) {
            System.out.println("EXCEPTION (NPE)! " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION (IAE)! " + e.getMessage());
        }
    }
}
