import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap();
    Scanner scanner = new Scanner(System.in);
    MonthData monthData = new MonthData();
    Converter converter = new Converter();
    public static int purpose = 10001;

    public StepTracker() {
        for (int i = 1; i < 13; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void addStepsPerDay() {
        System.out.println("Введи нужный месяц, если 1-январь, а 12-декабрь");
        int month = scanner.nextInt();
        System.out.println("Введи день от 1 до 31");
        int day = scanner.nextInt();1
        while (day < 0) {
            System.out.println("Шагов не может быть меньше 0");
        }
        while (day > 32) {
            System.out.println("Шагов не может быть больше 32");
        }

        day = scanner.nextInt();
        System.out.println("Введи количество пройденных шагов");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Введи положительное число шагов");
            steps = scanner.nextInt();
        }
        iscorrect(day,month,steps);
        monthToData.get(month).addSteps(--day, steps);
        System.out.println();
        System.out.println("Данные успешно добавлены");
        System.out.println();
    }

    public void iscorrect(int day, int month, int steps) {// исключение ошибок
        boolean isDayCorrect = 0 < day && day < 32;
        System.out.println("Не верно введено кол-во дней");
        boolean isMonthCorrect = 1 < month && month < 13;
        System.out.println("Не верно введен месяц");
        boolean isStepsCorrect = steps > 0;
        System.out.println("Шагов априори не может быть меньше 0 в день");
        if (isDayCorrect && isMonthCorrect && isStepsCorrect) {
            ((MonthData) this.monthToData.get(month)).addSteps(day, steps);
            System.out.println("Данные сохранены");
        } else {
            System.out.println("Что-то пошло не так, проверь правильность ввода");
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
                currentSeries = currentSeries + 1;
                if (currentSeries > maxSeries) {
                    maxSeries = currentSeries;
                }
            } else if (monthToData.get(month).days[i] < purpose){
                    if (currentSeries > maxSeries) {
                        maxSeries = currentSeries;
                    }
                    currentSeries = 0;
            }
        }
        return maxSeries;
    }

}