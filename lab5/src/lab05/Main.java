package lab05;

import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        System.out.println("Метод 1: Insertion sort | Метод 2: Bubble sort");

        System.out.println(">>> 1. ДЕМОНСТРАЦІЯ МЕТОДУ 1 (Task1: Insertion sort по спаданню)");
        Task1.main(args);
        System.out.println();

        System.out.println(">>> 2. ДЕМОНСТРАЦІЯ МЕТОДУ 2 (Task2: Bubble sort по спаданню)");
        Task2.main(args);
        System.out.println();

        System.out.println(">>> 3. ДЕМОНСТРАЦІЯ ТА ПЕРЕВІРКА ПРАКТИЧНИХ КОНТРОЛЬНИХ ПИТАНЬ");

        demonstrateControlQuestions();
    }

    private static void demonstrateControlQuestions() {
        System.out.println("-- 1. Дослідження Best Case vs Worst Case (Питання 2, 3) --");
        byte[] bestCase = {50, 40, 30, 20, 10};  // Вже відсортований по спаданню
        byte[] worstCase = {10, 20, 30, 40, 50}; // Відсортований у зворотному напрямку

        System.out.println("Вхідний масив Best Case (N = 5):  " + Arrays.toString(bestCase));
        System.out.println("Вхідний масив Worst Case (N = 5): " + Arrays.toString(worstCase));

        Task1.SortMetrics bestInsert = Task1.insertionSortWithMetrics(Arrays.copyOf(bestCase, 5));
        Task1.SortMetrics worstInsert = Task1.insertionSortWithMetrics(Arrays.copyOf(worstCase, 5));
        Task1.SortMetrics bestBubble = Task2.bubbleSortWithMetrics(Arrays.copyOf(bestCase, 5));
        Task1.SortMetrics worstBubble = Task2.bubbleSortWithMetrics(Arrays.copyOf(worstCase, 5));

        System.out.println("\nРезультати для Insertion Sort:");
        System.out.println("  Best Case  -> " + bestInsert + " (Лінійний час O(n))");
        System.out.println("  Worst Case -> " + worstInsert + " (Квадратичний час O(n^2))");

        System.out.println("\nРезультати для Bubble Sort (з оптимізацією swapped):");
        System.out.println("  Best Case  -> " + bestBubble + " (Лінійний час O(n) завдяки перевірці swapped)");
        System.out.println("  Worst Case -> " + worstBubble + " (Квадратичний час O(n^2))");
        System.out.println();

        System.out.println(" 2. Перевірка роботи з граничними значеннями типу byte (-128 .. 127) --");
        byte[] extremes = {Byte.MIN_VALUE, 0, Byte.MAX_VALUE, -1, 1, -50, 50};
        System.out.println("До сортування:  " + Arrays.toString(extremes));
        Task1.insertionSort(extremes);
        System.out.println("Після Insertion Sort по спаданню: " + Arrays.toString(extremes));
        System.out.println("Найбільший елемент на першій позиції: " + (extremes[0] == Byte.MAX_VALUE));
        System.out.println("Найменший елемент на останній позиції: " + (extremes[extremes.length - 1] == Byte.MIN_VALUE));
        System.out.println();

        System.out.println(" 3. Оцінка використання додаткової пам'яті (Питання 2: O(1) in-place) --");
        System.out.println("Обидва алгоритми сортують масив 'на місці' (in-place).");
        System.out.println("Для їх роботи потрібна лише фіксована кількість скалярних змінних (i, j, key, temp, swapped),");
        System.out.println("тому додаткова пам'ять становить O(1) і не залежить від розміру N.");
    }
}
