package lab06;

/**
 * Головний клас для демонстрації роботи Лабораторної роботи №6 (String, Варіант 6).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Завдання 1: octStringToInt | Завдання 2: countWords");

        System.out.println(">>> 1. ДЕМОНСТРАЦІЯ МЕТОДУ 1 (Task1: octStringToInt)");
        Task1.main(args);
        System.out.println();

        System.out.println(">>> 2. ДЕМОНСТРАЦІЯ МЕТОДУ 2 (Task2: countWords)");
        Task2.main(args);
        System.out.println();

        System.out.println(">>> 3. ДЕМОНСТРАЦІЯ ТА ПЕРЕВІРКА ПРАКТИЧНИХ КОНТРОЛЬНИХ ПИТАНЬ");
        demonstrateControlQuestions();
    }

    /**
     * Практичні приклади та наочна перевірка відповідей на контрольні питання.
     */
    private static void demonstrateControlQuestions() {
        System.out.println("-- 1. Дослідження незмінності (Immutability) класу String (Питання 1) --");
        String original = "kpi";
        String modified = original.toUpperCase();
        System.out.println("Початковий рядок original:           \"" + original + "\"");
        System.out.println("Результат original.toUpperCase():    \"" + modified + "\"");
        System.out.println("original після виклику toUpperCase:  \"" + original + "\" (рядок НЕ змінився!)");
        System.out.println();

        System.out.println("-- 2. Регулярні вирази (RegEx) для валідації типів лексем (Питання 2) --");
        String testWord = "HelloWorld";
        String testNum = "757677";
        String testCombo = "croco181dile920";
        System.out.printf("Чи є \"%s\" словом (^[a-zA-Z]+$):              %b%n", testWord, testWord.matches("^[a-zA-Z]+$"));
        System.out.printf("Чи є \"%s\" цілим числом (^\\d+$):             %b%n", testNum, testNum.matches("^\\d+$"));
        System.out.printf("Чи є \"%s\" комбінацією (^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$): %b%n",
                testCombo, testCombo.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$"));
        System.out.println();

        System.out.println("-- 3. Порівняння оператора '==' та методу 'equals()' (Питання 3) --");
        String literal1 = "Java";
        String literal2 = "Java";
        String constructed = new String("Java");
        System.out.println("literal1 == literal2 (обидва з String Pool):       " + (literal1 == literal2));
        System.out.println("literal1 == constructed (Heap об'єкт проти Pool):  " + (literal1 == constructed));
        System.out.println("literal1.equals(constructed) (посимвольний вміст): " + literal1.equals(constructed));
        System.out.println("literal1 == constructed.intern() (інтернування):   " + (literal1 == constructed.intern()));
        System.out.println();

        System.out.println("-- 4. Ефективність StringBuilder проти конкатенації (Питання 4) --");
        StringBuilder sb = new StringBuilder("Start");
        sb.append(" -> Middle").append(" -> End");
        System.out.println("Результат мутабельного буфера: " + sb.toString());
        System.out.println();

        System.out.println("-- 5. Видалення пробільних символів: trim() vs strip() (Питання 5) --");
        String spaced = "   \t  Привіт, КПІ!   \n  ";
        System.out.println("Оригінальний рядок:   [" + spaced + "]");
        System.out.println("Після .trim():        [" + spaced.trim() + "]");
        System.out.println("Після .strip():       [" + spaced.strip() + "]");
    }
}
