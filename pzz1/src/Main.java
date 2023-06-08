import java.util.Scanner;

public class Main {
    private static final String[] questions = {
            "1. _____ you like pizza?",
            "2. She _____ to work every day.",
            "3. They _____ basketball on weekends.",
            "4. He _____ a lot of books.",
            "5. _____ they play video games?"
    };

    private static final String[][] options = {
            {"a) Do", "b) Does", "c) Did", "d) Doing"},
            {"a) go", "b) goes", "c) went", "d) going"},
            {"a) plays", "b) played", "c) play", "d) playing"},
            {"a) have", "b) has", "c) had", "d) having"},
            {"a) Do", "b) Does", "c) Did", "d) Doing"}
    };

    private static final String[] correctAnswers = {"a", "b", "c", "a", "b"};
    private static final String ADMIN_PASSWORD = "1111";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Привіт! Це тест на тему \"Feature Perfect Continous  \".");
        System.out.print("Введіть ваше прізвище, ім'я та по батькові: ");
        String fullName = scanner.nextLine();

        System.out.println("Почнемо тестування. Введіть a, b, c або d як відповідь. Введіть 'q' для виходу.");

        int totalQuestions = questions.length;
        int correctAnswersCount = 0;

        for (int i = 0; i < totalQuestions; i++) {
            System.out.println("\n" + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("q")) {
                break;
            } else if (answer.equals("1111")) {
                showCorrectAnswers();
                break;
            } else if (!answer.matches("[a-d]")) {
                System.out.println("Будь ласка, введіть a, b, c або d.");
                i--;
                continue;
            }

            if (answer.equals(correctAnswers[i])) {
                correctAnswersCount++;
            }
        }

        double scorePercentage = (double) correctAnswersCount / totalQuestions * 100;

        System.out.println("\nТестування завершено!");
        System.out.println("Результат: " + correctAnswersCount + " з " + totalQuestions + " питань відповідно.");
        System.out.printf("Ви набрали %.2f%% правильних відповідей.\n", scorePercentage);
        System.out.println("\nДякую за участь!");

        System.out.println("\nПрограму розроблено: " + fullName);
    }

    private static void showCorrectAnswers() {
        System.out.println("\nПравильні відповіді:");

        for (int i = 0; i < correctAnswers.length; i++) {
            System.out.println(questions[i] + " " + options[i][getOptionIndex(correctAnswers[i])]);
        }
    }

    private static int getOptionIndex(String answer) {
        switch (answer) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            default:
                return -1;
        }
    }
}
