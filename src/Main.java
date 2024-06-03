import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        PrintMenu.printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 4) {
            if (userInput == 1) {
                stepTracker.addStepsPerDay();
            } else if (userInput == 2) {
                System.out.println("Какой месяц интересует?");
                int month = scanner.nextInt();
                stepTracker.getStatistics();
            } else if (userInput == 3) {
                System.out.println("Введи новую цель");
                int goal = scanner.nextInt();
                if (goal >= 0) {
                    stepTracker.purpose(goal);
                } else {
                    System.out.println(" Не надо лениться");
                }
            } else {
                System.out.println("Такая команда не предусмотрена");
                System.out.println();
            }
            PrintMenu.printMenu();
            System.out.println();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }
}