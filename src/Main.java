import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        PrintMenu.printMenu();
        System.out.println();
        try {
            while (true) {
                int userInput = scanner.nextInt();
                while (userInput != 4) {
                    if (userInput == 1) {
                        stepTracker.addStepsPerDay();
                    } else if (userInput == 3) {
                        System.out.println("Помни, минимум шагов в день 10 000, а теперь введи свой показатель:");
                        int newPurpose = scanner.nextInt();
                        if (newPurpose > 0) {
                            stepTracker.changePurpose(newPurpose);
                        } else {
                            System.out.println("Возьми себя в руки и вбей новую цель");
                            System.out.println();
                        }
                    } else if (userInput == 2) {
                        System.out.println("Выбери месяц 1-январь, 12-декабрь");
                        int month = scanner.nextInt();
                        stepTracker.getStatistics(month);
                    } else {
                        System.out.println("Такая команда не предусмотрена");
                    }
                    PrintMenu.printMenu();
                    userInput = scanner.nextInt();
                }
                System.out.println("Программа завершена");

            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели букву вместо цифры, для продолжения запустите программу заново");
        }
    }
}