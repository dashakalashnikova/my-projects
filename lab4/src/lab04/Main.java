package lab04;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("Лабораторна робота №4 з курсу «Основи програмування»");
        System.out.println("Тема: Масиви");
        System.out.println("Студентка: Калашнікова Дар'я, Група: ЦК-41, Варіант №6");
        System.out.println("===============================================================\n");

        System.out.println(">>> 1. ДЕМОНСТРАЦІЯ ЗАВДАННЯ №1 (Таблиця 2, №6)");
        System.out.println("Умова: Знайти мінімальний елемент, що кратний 5 (цикл for-each)");
        Task1.main(args);
        System.out.println();

        System.out.println(">>> 2. ДЕМОНСТРАЦІЯ ЗАВДАННЯ №2 (Таблиця 2, №36)");
        System.out.println("Умова: Визначити середнє геометричне номерів min та max елементів (цикл for)");
        Task2.main(args);
        System.out.println();

        System.out.println(">>> 3. ДЕМОНСТРАЦІЯ ЗАВДАННЯ №3 (Таблиця 2, №66)");
        System.out.println("Умова: Сформувати масив C(n+m) з елементів масиву A(n) та масиву B(m)");
        Task3.main(args);
        System.out.println();

        System.out.println("===============================================================");
        System.out.println(">>> 4. ДЕМОНСТРАЦІЯ ТА ПЕРЕВІРКА ПРАКТИЧНИХ КОНТРОЛЬНИХ ПИТАНЬ");
        System.out.println("===============================================================\n");

        System.out.println("-- Контрольне питання №5 (Індекси масиву з 10 елементів) --");
        int[] arr10 = new int[10];
        System.out.println("Розмір масиву: " + arr10.length);
        System.out.println("Перший індекс: 0, Останній індекс: " + (arr10.length - 1));
        System.out.println();

        System.out.println("-- Контрольне питання №6 (Звернення до неіснуючої комірки) --");
        try {
            int val = arr10[10]; // спроба звернення за межі
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Зловлено очікуване виключення: " + e);
        }
        System.out.println();

        System.out.println("-- Контрольне питання №7 (Значення комірок за замовчуванням) --");
        int[] defaultInts = new int[3];
        double[] defaultDoubles = new double[3];
        boolean[] defaultBools = new boolean[3];
        String[] defaultStrings = new String[3];
        System.out.println("int[] default: " + Arrays.toString(defaultInts));
        System.out.println("double[] default: " + Arrays.toString(defaultDoubles));
        System.out.println("boolean[] default: " + Arrays.toString(defaultBools));
        System.out.println("String[] default: " + Arrays.toString(defaultStrings));
        System.out.println();

        System.out.println("-- Контрольне питання №10 (Копіювання посилання на масив) --");
        int[] original = {1, 2, 3};
        int[] referenceCopy = original;
        referenceCopy[0] = 999;
        System.out.println("original після зміни referenceCopy[0]: " + Arrays.toString(original));
        System.out.println("referenceCopy: " + Arrays.toString(referenceCopy));
        System.out.println();

        System.out.println("-- Контрольне питання №13 (Запис int у double[] та навпаки) --");
        double[] doubleArr = new double[2];
        int intVal = 42;
        doubleArr[0] = intVal; // Неявне автоматичне розширення (widening conversion)
        System.out.println("Успішно записано int " + intVal + " у double[]: " + doubleArr[0]);
        // int[] intArr = new int[2];
        // intArr[0] = 3.14; // Помилка компіляції: Type mismatch: cannot convert from double to int!
        int[] intArr = new int[2];
        intArr[0] = (int) 3.14; // Дозволено лише з явним приведенням типів (втрата дробової частини)
        System.out.println("Запис double у int[] можливий лише з явним приведенням (int) 3.14: " + intArr[0]);
    }
}
