import java.util.Random;
import java.util.Scanner;

class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = false;

        do {
            System.out.println("Выберите режим игры:");
            System.out.println("1 - Игра с фиксированным диапазоном (0-9, 3 попытки)");
            System.out.println("2 - Игра с выбором диапазона и количества попыток");
            System.out.println("3 - Выход из программы");
            int mode = scanner.nextInt();

            if (mode == 3) {
                System.out.println("Выход из программы. Спасибо за игру!");
                break; // Завершаем программу
            }

            int secretNumber;
            int attempts;

            if (mode == 1) {
                // Режим 1: фиксированный диапазон от 0 до 9 и 3 попытки
                secretNumber = random.nextInt(10); // Случайное число от 0 до 9
                attempts = 3;
                System.out.println("Я загадал число от 0 до 9. У вас " + attempts + " попыток.");
            } else if (mode == 2) {
                // Режим 2: выбор диапазона и количества попыток
                System.out.println("Введите минимальное значение диапазона:");
                int min = scanner.nextInt();
                System.out.println("Введите максимальное значение диапазона:");
                int max = scanner.nextInt();
                System.out.println("Введите количество попыток:");
                attempts = scanner.nextInt();
                secretNumber = random.nextInt(max - min + 1) + min;
                System.out.println("Я загадал число от " + min + " до " + max + ". У вас " + attempts + " попыток.");
            } else {
                System.out.println("Неверный выбор режима. Попробуйте снова.");
                continue; // Возвращаемся к началу цикла
            }

            boolean guessed = false;

            for (int i = 0; i < attempts; i++) {
                System.out.println("Попытка " + (i + 1) + ": Введите ваше число:");
                int userGuess = scanner.nextInt();

                if (userGuess < secretNumber) {
                    System.out.println("Загаданное число больше.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Загаданное число меньше.");
                } else {
                    System.out.println("Поздравляю! Вы угадали число!");
                    guessed = true;
                    break;
                }
            }

            if (!guessed) {
                System.out.println("Вы исчерпали все попытки. Загаданное число было: " + secretNumber);
            }

            System.out.println("Хотите сыграть еще раз? 1 - да, 0 - нет:");
            playAgain = scanner.nextInt() == 1;

        } while (playAgain);

        System.out.println("Спасибо за игру!");
        scanner.close();
    }
}