import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    MonthData monthData = new MonthData();
    Converter converter = new Converter();
    public static int purpose = 10001;
    public static int month = 0;
    public static int day = 0;
    public static int steps = 0;

    public StepTracker() {
        for (int i = 1; i < 13; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void addStepsPerDay() {
        System.out.println("Введи нужный месяц, если 1-январь, а 12-декабрь");
        StepTracker.month = scanner.nextInt();
        isMonthCorrect(month);
    }


    public void isMonthCorrect(int month) {
        final var isMonthCorrect = 0 < StepTracker.month && StepTracker.month < 13;
        if (isMonthCorrect) {
            isDayCorrect(StepTracker.day);
        } else {
            System.out.println("Месяц введён не корректно, от 1 до 12");
            addStepsPerDay();
        }
    }

    public void isDayCorrect(int day) {
        System.out.println("Введи день от 1 до 31");
        StepTracker.day = scanner.nextInt();
        final var isDayCorrect = 0 < StepTracker.day && StepTracker.day < 32;
        if (isDayCorrect) {
            isStepsCorrect(StepTracker.steps);
        } else {
            System.out.println("День указан не верно, от 1 до 31");
            isDayCorrect(StepTracker.day);
        }
    }

    public void isStepsCorrect(int steps) {
        System.out.println("Введи кол-во шагов");
        StepTracker.steps = scanner.nextInt();
        final var isStepsCorrect = StepTracker.steps > 0;
        if (isStepsCorrect) {
            monthToData.get(StepTracker.month).addSteps(--StepTracker.day, StepTracker.steps);
        } else {
            System.out.println("Кол-во шагов указано не верно, не меньше 0");
            isStepsCorrect(steps);
        }
    }

    public void changePurpose(int newPurpose) {
        purpose = newPurpose;
        System.out.println("Новая цель: " + newPurpose + " шага(ов)!");
        System.out.println();
    }

    public void getStatistics(int month) {
        getDaysSteps(month);
        System.out.println();
        System.out.println("Общее количество шагов за " + month + " месяц: " + getStepsPerMonth(month));
        System.out.println("Максимальное количество шагов в " + month + " месяце: " + getMaxStepsMonth(month));
        System.out.println("Среднее количество шагов за " + month + " месяц: " + getAverageOfSteps(month));
        getDistance(month);
        getCCalories(month);
        System.out.println("Best серия из " + getMaxPurposeSteps(month) + " дней.");
        System.out.println();
    }

    public void getDaysSteps(int month) {
        System.out.println("Твоя статистика за " + month + " месяц:");
        for (int i = 0; i < monthData.days.length; i++) {
            System.out.println("За " + (i + 1) + " день ты сделал " + monthToData.get(month).days[i] + " шагов");
        }

    }

    public int getStepsPerMonth(int month) {
        int steps = 0;
        for (int i = 0; i < monthData.days.length; i++) {
            steps = monthToData.get(month).days[i] + steps;
        }
        return steps;

    }

    public void getDistance(int month) {
        int steps = getStepsPerMonth(month);
        System.out.println("Ты прошагал уже " + converter.convertingSteps(steps) + " км");

    }

    public void getCCalories(int month) {
        int steps = getStepsPerMonth(month);
        System.out.println("Ты сжёг уже " + converter.convertingCcallories(steps) + " ккал");
    }

    public int getAverageOfSteps(int month) {
        return getStepsPerMonth(month) / monthData.days.length;

    }

    public int getMaxStepsMonth(int month) {
        int max = 0;
        for (int i = 0; i < monthToData.get(month).days.length; i++) {
            if (monthToData.get(month).days[i] > max) {
                max = monthToData.get(month).days[i];
            }
        }
        return max;
    }

    public int getMaxPurposeSteps(int month) {
        int currentSeries = 0;
        int maxSeries = 0;
        for (int i = 0; i < monthData.days.length; i++) {
            if (monthToData.get(month).days[i] >= purpose) {
                currentSeries++;
            } else {
                if (currentSeries > maxSeries) {
                    maxSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }
        if (currentSeries > maxSeries){
            maxSeries = currentSeries;
        }
        return maxSeries;
    }
}

