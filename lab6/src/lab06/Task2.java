package lab06;

/**
 * Завдання №2: Підрахунок кількості слів у реченні (пункт 7 Таблиці 2).
 * Словом вважається неперервна послідовність символів, що складається
 * виключно з літер латинського алфавіту (a-z, A-Z).
 */
public class Task2 {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТУВАННЯ МЕТОДУ 2: countWords (ВАРІАНТ 6) ===");

        // Дозволені набори вхідних даних
        // 1. Контрольний приклад з методичних вказівок (очікується 19 слів)
        printResults("The user with the nickname koala757677 this month left 3 times more comments than the user with the nickname croco181dile181920 4 months ago");

        // 2. Речення виключно зі слів
        printResults("Hello World from Java programming language");

        // 3. Речення без слів — тільки числа
        printResults("100 200 500 1024 2026");

        // 4. Речення без слів — тільки комбінації літер і цифр
        printResults("id100 var2 007agent user42");

        // 5. Змішане речення
        printResults("Cat 42 dog7 fish 100 bird");

        // 6. Речення з багатьма пробілами та табуляціями
        printResults("   Java    is   great   and    fast   ");

        // 7. Порожній рядок
        printResults("");

        // 8. Рядок лише з пробільних символів
        printResults("   \t  \n  ");

        // Заборонені комбінації аргументів (помилкові)
        printResults(null); // null посилання
    }

    /**
     * Підраховує кількість слів у реченні.
     * Словом вважається послідовність символів, що складається
     * виключно з літер латинського алфавіту (a-z, A-Z).
     *
     * Згідно з п.1 ходу роботи, розбиття речення на окремі токени виконується
     * за допомогою методу {@link String#split(String)}, а перевірка символів токена —
     * за допомогою {@link String#toCharArray()}
     */
    public static int countWords(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Речення не може бути null");
        }

        String trimmed = sentence.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }

        String[] tokens = trimmed.split("\\s+");
        int wordCount = 0;

        for (String token : tokens) {
            if (isWord(token)) {
                wordCount++;
            }
        }

        return wordCount;
    }

    /**
     * Перевіряє, чи є переданий токен словом (містить лише літери a-z, A-Z).
     */
    public static boolean isWord(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        for (char c : token.toCharArray()) {
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Допоміжний метод для друку результатів тестування методу countWords.
     */
    public static void printResults(String sentence) {
        String display = (sentence == null) ? "null"
                : (sentence.length() > 50 ? "\"" + sentence.substring(0, 47) + "...\"" : "\"" + sentence + "\"");
        System.out.print("Початковий: " + display);
        try {
            int words = countWords(sentence);
            System.out.println(" -> Кількість слів: " + words);
        } catch (NullPointerException e) {
            System.out.println(" -> EXCEPTION (NPE)! " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(" -> EXCEPTION (IAE)! " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" -> EXCEPTION! " + e.getMessage());
        }
    }
}
