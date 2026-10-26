package lab05;

import java.util.Arrays;

/**
 * Завдання №1: Реалізація сортування включенням (вставкою, Insertion Sort)
 * для масиву типу byte[] за спаданням (descending order).
 */
public class Task1 {

    public static void main(String[] args) {
        System.out.println(" ТЕСТУВАННЯ МЕТОДУ 1: INSERTION SORT (ПО СПАДАННЮ) ");

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
     * Сортує переданий масив типу byte[] за спаданням методом вставки (Insertion Sort).
     * Модифікація масиву виконується in-place (на місці).
     *
     * @param array масив байтів для сортування
     * @throws NullPointerException якщо передано посилання null
     */
    public static void insertionSort(byte[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }

        // Порожній масив або масив з 1 елемента вже вважається відсортованим
        if (array.length <= 1) {
            return;
        }

        // Алгоритм сортування вставкою за спаданням
        for (int i = 1; i < array.length; i++) {
            byte key = array[i];
            int j = i - 1;

            // Для впорядкування за спаданням зміщуємо праворуч усі елементи,
            // які є меншими за поточний ключовий елемент key.
            // Строга нерівність (array[j] < key) забезпечує стабільність сортування:
            // елементи з однаковим значенням не міняються місцями.
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Допоміжний клас для збору метрик роботи алгоритму сортування.
     */
    public static class SortMetrics {
        public long comparisons = 0;
        public long assignments = 0;

        @Override
        public String toString() {
            return String.format("Порівнянь: %d, Переміщень (зсувів/присвоєнь): %d", comparisons, assignments);
        }
    }

    /**
     * Виконує сортування вставкою за спаданням з точним підрахунком операцій порівняння та присвоєння.
     *
     * @param array масив байтів
     * @return об'єкт з метриками виконання
     */
    public static SortMetrics insertionSortWithMetrics(byte[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }

        SortMetrics metrics = new SortMetrics();
        if (array.length <= 1) {
            return metrics;
        }

        for (int i = 1; i < array.length; i++) {
            byte key = array[i];
            metrics.assignments++; // читання key
            int j = i - 1;

            while (j >= 0) {
                metrics.comparisons++;
                if (array[j] < key) {
                    array[j + 1] = array[j];
                    metrics.assignments++; // зсув елемента праворуч
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
            metrics.assignments++; // вставка key
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
            SortMetrics metrics = insertionSortWithMetrics(copy);
            System.out.println(" -> Відсортований: " + Arrays.toString(copy) + " | " + metrics);
        } catch (NullPointerException e) {
            System.out.println(" -> EXCEPTION (NPE)! " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" -> EXCEPTION! " + e.getMessage());
        }
    }
}
