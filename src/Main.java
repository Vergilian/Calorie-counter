import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        stepTracker.StepTracker();
        PrintMenu.printMenu();

        for (int userInput = scanner.nextInt(); userInput != 4; userInput = scanner.nextInt()) {
            if (userInput == 1) {
                stepTracker.addStepsPerDay();
            } else if (userInput == 2) {
                System.out.println("Какой месяц интересует?");
            }

            PrintMenu.printMenu();
        }

        System.out.println("Завершение программы");
    }
}