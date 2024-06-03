public class MonthData {
    int [] monthDays;

    MonthData() {
        monthDays = new int[31];
    }

    public void addSteps(int day, int steps) {
        monthDays[day] = steps;
    }
}