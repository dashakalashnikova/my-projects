public class Main {
    public static void main(String[] args) {
        System.out.println("Практична робота №2 з Java");
        System.out.println("Студентка: Калашнікова Дар'я, Варіант №6");
        System.out.println("----------------------------------------");

        // Завдання №1 (розрахунок виразу 16)
        double a16 = 0.58;
        double b16 = 0.34;
        double c16 = 1.25;
        double d16 = -1.89;

        double numerator16 = 2 * Math.sin(a16);
        double denominator16 = Math.acos(-2 * b16);
        double sqrtPart16 = Math.sqrt(Math.log(c16 * Math.abs(2 * d16)));
        double y16 = (numerator16 / denominator16) - sqrtPart16;

        System.out.println("1) Вираз 16:");
        System.out.println("   Параметри: a = " + a16 + ", b = " + b16 + ", c = " + c16 + ", d = " + d16);
        System.out.println("   Результат: y = " + y16);
        System.out.println();

        // Завдання №2 (розрахунок виразу 17)
        double a17 = -1.49;
        double b17 = 23.4;
        double c17 = 1.23;
        double d17 = 2.254;

        double termRadical17 = 2 * Math.sqrt(Math.abs(Math.tan(a17) + c17));
        double termLog17 = Math.log(b17) / Math.pow(c17, d17);
        double y17 = termRadical17 + termLog17;

        System.out.println("2) Вираз 17:");
        System.out.println("   Параметри: a = " + a17 + ", b = " + b17 + ", c = " + c17 + ", d = " + d17);
        System.out.println("   Результат: y = " + y17);
        System.out.println();

        // Завдання №3 (розрахунок виразу 18)
        double a18 = 2.34;
        double b18 = 0.756;
        double c18 = 2.23;
        double d18 = -1.653;

        double upper18 = Math.exp(c18) + 2 * Math.log10(a18);
        double lower18 = Math.sqrt(Math.pow(c18, b18));
        double y18 = (upper18 / lower18) * Math.abs(Math.asin(d18));

        System.out.println("3) Вираз 18:");
        System.out.println("   Параметри: a = " + a18 + ", b = " + b18 + ", c = " + c18 + ", d = " + d18);
        System.out.println("   Результат: y = " + y18 + " (NaN, бо Math.asin(-1.653) поза межами [-1; 1])");

        // якщо в методичці малося на увазі arctg замість arcsin:
        double y18Atan = (upper18 / lower18) * Math.abs(Math.atan(d18));
        System.out.println("   Альтернатива з arctg: y = " + y18Atan);
        System.out.println();

        // ----------------------------------------------------
        // Демонстраційні фрагменти до контрольних питань
        // ----------------------------------------------------
        System.out.println("----------------------------------------");
        System.out.println("Перевірка фрагментів коду з питань:");

        // Питання 8 (переповнення цілого числа)
        int firstInt = 2_000_000_000;
        int secondInt = 2_000_000_000;
        int totalInt = firstInt + secondInt;
        System.out.println("№8: 2_000_000_000 + 2_000_000_000 = " + totalInt);

        // Питання 12 (порівняння не-числа)
        System.out.println("№12: Double.NaN == Double.NaN повертає " + (Double.NaN == Double.NaN));

        // Питання 16 (пріоритети та присвоювання)
        boolean testA = true && false | false;
        System.out.println("№16 (перший вивід): " + (testA = false));

        boolean testB = true && false || false;
        System.out.println("№16 (другий вивід): " + (testB = true));
    }
}
