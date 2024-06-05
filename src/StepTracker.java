import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap();
    Scanner scanner = new Scanner(System.in);
    MonthData monthData = new MonthData();
    Converter converter = new Converter();
    int purpose = 10001;

    public StepTracker() {
        for (int i = 1; i < 13; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void addStepsPerDay() {
        System.out.println("За какой месяц ввести шаги?");
        System.out.println("Введи нужный месяц, если 1-январь, а 12-декабрь");
        int month = scanner.nextInt();
        System.out.println("Введи день от 1 до 31");
        int day = scanner.nextInt();
        System.out.println("Введи количество пройденных шагов");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Введи положительное число");
            steps = scanner.nextInt();
        }
        monthToData.get(month).addSteps(day, steps);
    }

    public void correct(int day, int month, int steps) {// исключение ошибок
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

    public void purpose(int newPurpose) {
        purpose = newPurpose;
        System.out.println("Новая цель: " + newPurpose + " шага(ов)!");
    }

    public void getStatistics(int month) {
        getDaysSteps(month);
        System.out.println("Общее количество шагов за " + month + " месяц: " + getStepsPerMonth(month));
        System.out.println("Максимальное количество шагов в " + month + " месяце: " + getMaxStepsMonth(month));
        System.out.println("Среднее количество шагов за " + month + " месяц: " + getAverageOfSteps(month));
        getDistance(month);
        getCCalories(month);
        System.out.println("Best серия из " + getMaxPurposeSteps(month) + " дней.");
    }
    public void getDaysSteps (int month ) {
        System.out.println("Твоя статистика за " + month + " месяц:");
        for (int i = 0; i < monthData.monthDays.length; i++){
            System.out.println(...);
        }

    }
    public int getStepsPerMonth(int month){
        int steps = 0;
        for (int i = 0; i < monthData.monthDays.length; i++){
            steps = monthToData.get(month).monthDays[i] + steps;
        }
        return steps;

    }

    public void getDistance(int month){
        int steps = getStepsPerMonth(month);
        System.out.println("Ты прошагал уже " + converter.convertingSteps(steps) + " км");

    }

    public void getCCalories(int month){
        int steps = getStepsPerMonth(month);
        System.out.println("Ты сжёг уже " + converter.convertingCcallories(steps) + " ккал");
    }

    public int getAverageOfSteps(int month){
        return getStepsPerMonth(month)/monthData.monthDays.length;

    }
    public int getMaxStepsMonth(int month){

    }

    public int getMaxPurposeSteps(int month){

    }

}