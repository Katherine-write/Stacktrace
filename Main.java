import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите мин. длину пароля и макс. допустимое количество повторений символа подряд: ");
        String input = scanner.nextLine();


        try {
            String[] parts = input.split(" ");
            int minLength = Integer.parseInt(parts[0]);
            int maxRepeats = Integer.parseInt(parts[1]);

            PasswordChecker passwordChecker = new PasswordChecker();
            passwordChecker.setMinLength(minLength);
            passwordChecker.setMaxRepeats(maxRepeats);

            while (true) {

                System.out.println("Введите пароль или end: ");
                String password = scanner.nextLine();

                if (password.equals("end")) {
                    break;
                }


                boolean isValid = passwordChecker.verify(password);
                if (isValid) {
                    System.out.println("Пароль корректен.");
                } else {
                    System.out.println("Пароль некорректен.");
                    if (passwordChecker.repeatsCounter(password) >= maxRepeats) {
                        System.out.println("Вы превысили максимальное допустимое количество повторений символа подряд!");
                    }
                    if (passwordChecker.getMinLength() >= password.length()) {
                        System.out.println("Недопустимая длина пароля!");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Некоректный ввод данных");
        }


    }
}