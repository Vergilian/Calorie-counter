import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap();
    Scanner scanner;

    public StepTracker() {
        this.scanner = new Scanner(System.in);
    }

    public void StepTracker() {
        for (int i = 1; i < 13; ++i) {
            this.monthToData.put(i, new MonthData());
        }

    }

    public void addStepsPerDay() {
        System.out.println("За какой месяц ввести шаги?");
        System.out.println("Введи нужный месяц, если 1-январь, а 12-декабрь");

        int month;
        for (month = this.scanner.nextInt(); month < 1 && month > 13; month = this.scanner.nextInt()) {
            System.out.println("Серьёзно? Введи нормальный месяц");
        }

        System.out.println("Введи день от 1 до 31");
        int day = this.scanner.nextInt();
        System.out.println("Введи количество пройденных шагов");

        int steps;
        for (steps = this.scanner.nextInt(); steps < 0; steps = this.scanner.nextInt()) {
            System.out.println("Перестань, ты ведь не ходишь спиной, введи положительное число");
        }

        ((MonthData) this.monthToData.get(month)).addSteps(day, steps);
    }

    public void correct(int day, int month, int steps) {
        boolean isDayCorrect = 0 < day && day < 32;
        boolean isMonthCorrect = 1 < month && month < 13;
        boolean isStepsCorrect = steps > 0;
        if (isDayCorrect && isMonthCorrect && isStepsCorrect) {
            ((MonthData) this.monthToData.get(month)).addSteps(day, steps);
            System.out.println("Данные сохранены");
        } else {
            System.out.println("Что-то пошло не так, проверь правильность ввода");
        }

    }
}