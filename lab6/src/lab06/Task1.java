package lab06;

/**
 * Завдання №1: Перетворення рядка String, що представляє число у вісімковій
 * системі числення, у значення типу int (пункт 6 Таблиці 2).
 */
public class Task1 {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТУВАННЯ МЕТОДУ 1: octStringToInt (ВАРІАНТ 6) ===");

        // Дозволені набори вхідних даних
        printResults("777");            // Приклад з методички (очікується 511)
        printResults("0");              // Нуль
        printResults("10");             // 8 у десятковій
        printResults("175");            // 125 у десятковій
        printResults("+777");           // Додатний знак
        printResults("-777");           // Від'ємний знак (-511)
        printResults("-1");             // -1
        printResults("00052");          // Число з провідними нулями (42)
        printResults("17777777777");    // Граничне максимальне значення Integer.MAX_VALUE (2147483647)
        printResults("-20000000000");   // Граничне мінімальне значення Integer.MIN_VALUE (-2147483648)

        // Заборонені комбінації аргументів (помилкові)
        printResults(null);             // null посилання
        printResults("");               // Порожній рядок
        printResults("   ");            // Рядок лише з пробілів
        printResults("+");              // Лише знак плюс
        printResults("-");              // Лише знак мінус
        printResults("8");              // Невісімкова цифра 8
        printResults("789");            // Цифри 8 і 9
        printResults("CAFE");           // Шістнадцяткові символи
        printResults("12 34");          // Пробіл всередині числа
        printResults("20000000000");    // Переповнення зверху (> Integer.MAX_VALUE)
        printResults("-20000000001");   // Переповнення знизу (< Integer.MIN_VALUE)
    }

    /**
     * Перетворює String, що представляє собою число у вісімковій системі числення,
     * у значення типу int.
     *
     * Алгоритм реалізує посимвольний розбір (схема Горнера) із суворою перевіркою
     * приналежності кожного символу до вісімкового алфавіту ('0'..'7') та точним
     * контролем переповнення 32-бітного знакового діапазону int.
     */
    public static int octStringToInt(String s) {
        if (s == null) {
            throw new NullPointerException("Рядок не може бути null");
        }

        if (s.isEmpty()) {
            throw new IllegalArgumentException("Рядок не може бути порожнім");
        }

        boolean negative = false;
        int startIndex = 0;
        char firstChar = s.charAt(0);

        if (firstChar == '-') {
            negative = true;
            startIndex = 1;
        } else if (firstChar == '+') {
            startIndex = 1;
        }

        // Перевірка на випадок, коли рядок складається лише зі знаку "+" або "-"
        if (startIndex >= s.length()) {
            throw new IllegalArgumentException("Рядок не містить цифр, лише знак: \"" + s + "\"");
        }

        // Для безпечної перевірки переповнення використовуємо від'ємний акумулятор
        // (оскільки |Integer.MIN_VALUE| = 2147483648 > Integer.MAX_VALUE = 2147483647)
        int limit = negative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
        int multmin = limit / 8;
        int result = 0;

        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);

            // У вісімковій системі дозволені лише цифри від '0' до '7'
            if (c < '0' || c > '7') {
                throw new IllegalArgumentException(
                        "Неприпустимий символ вісімкової системи числення '" + c +
                        "' на позиції " + i + " у рядку \"" + s + "\"");
            }

            int digit = c - '0';

            // Перевірка на переповнення перед множенням на 8
            if (result < multmin) {
                throw new IllegalArgumentException(
                        "Переповнення діапазону типу int для вісімкового числа \"" + s + "\"");
            }
            result *= 8;

            // Перевірка на переповнення перед відніманням поточної цифри
            if (result < limit + digit) {
                throw new IllegalArgumentException(
                        "Переповнення діапазону типу int для вісімкового числа \"" + s + "\"");
            }
            result -= digit;
        }

        return negative ? result : -result;
    }

    /**
     * Допоміжний метод для друку результатів тестування методу octStringToInt.
     */
    public static void printResults(String s) {
        System.out.print("Початковий: " + (s == null ? "null" : "\"" + s + "\""));
        try {
            int result = octStringToInt(s);
            System.out.println(" -> Результат: " + result);
        } catch (NullPointerException e) {
            System.out.println(" -> EXCEPTION (NPE)! " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(" -> EXCEPTION (IAE)! " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" -> EXCEPTION! " + e.getMessage());
        }
    }
}
