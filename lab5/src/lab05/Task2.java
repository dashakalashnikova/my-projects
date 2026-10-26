package lab05;

import java.util.Arrays;

/**
 * Завдання №2: Реалізація сортування обміном (бульбашкою, Bubble Sort)
 * для масиву типу byte[] за спаданням (descending order).
 */
public class Task2 {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТУВАННЯ МЕТОДУ 2: BUBBLE SORT (ПО СПАДАННЮ) ===");

        // Дозволені набори вхідних даних
        printResults(new byte[]{12, 15, 7, 25, 5, 42});
        printResults(new byte[]{-10, -25, -5, 30, 0});
        printResults(new byte[]{50});
        printResults(new byte[]{0, 3, 7, 11});
        printResults(new byte[]{-128, 127, 0, -1, 1}); // Граничні значення byte
        printResults(new byte[]{10, 5, 20, 5, 30});     // Дублікати
        printResults(new byte[]{90, 80, 70, 60, 50});   // Вже відсортований за спаданням (найкращий випадок)
        printResults(new byte[]{10, 20, 30, 40, 50});   // Відсортований за зростанням (найгірший випадок)
        printResults(new byte[]{7, 7, 7, 7});           // Усі однакові елементи
        printResults(new byte[]{});                     // Порожній масив

        // Заборонені комбінації аргументів (помилкові)
        printResults(null); // null масив
    }

    /**
     * Сортує переданий масив типу byte[] за спаданням методом бульбашки (Bubble Sort).
     * Застосовано оптимізацію з прапорцем swapped та зменшенням діапазону перевірки.
     * Модифікація масиву виконується in-place (на місці).
     *
     * @param array масив байтів для сортування
     * @throws NullPointerException якщо передано посилання null
     */
    public static void bubbleSort(byte[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }

        if (array.length <= 1) {
            return;
        }

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // З кожною ітерацією зовнішнього циклу найменший елемент опускається (тоне) в кінець масиву,
            // тому внутрішній цикл перевіряє тільки перші (n - 1 - i) елементів.
            for (int j = 0; j < n - 1 - i; j++) {
                // Для сортування по спаданню: якщо поточний елемент менший за наступний, міняємо їх місцями
                // Строга нерівність (array[j] < array[j + 1]) гарантує стабільність сортування
                if (array[j] < array[j + 1]) {
                    byte temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // Оптимізація: якщо за повний прохід не відбулося жодного обміну,
            // масив уже повністю відсортований. Дострокове завершення за O(n).
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Виконує сортування бульбашкою за спаданням з точним підрахунком операцій порівняння та переміщення.
     *
     * @param array масив байтів
     * @return об'єкт з метриками виконання
     */
    public static Task1.SortMetrics bubbleSortWithMetrics(byte[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }

        Task1.SortMetrics metrics = new Task1.SortMetrics();
        if (array.length <= 1) {
            return metrics;
        }

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                metrics.comparisons++;
                if (array[j] < array[j + 1]) {
                    byte temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    metrics.assignments += 3; // Обмін через temp (3 операції копіювання)
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return metrics;
    }

    /**
     * Виводить результати тестування: початковий масив, відсортований масив та метрики,
     * або перехоплені виключення.
     */
    public static void printResults(byte[] array) {
        System.out.print("Початковий: " + (array == null ? "null" : Arrays.toString(array)));
        try {
            byte[] copy = (array == null) ? null : Arrays.copyOf(array, array.length);
            Task1.SortMetrics metrics = bubbleSortWithMetrics(copy);
            System.out.println(" -> Відсортований: " + Arrays.toString(copy) + " | " + metrics);
        } catch (NullPointerException e) {
            System.out.println(" -> EXCEPTION (NPE)! " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" -> EXCEPTION! " + e.getMessage());
        }
    }
}
