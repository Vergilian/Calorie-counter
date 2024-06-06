public class MonthData {
    int [] days;

    MonthData() {
        days = new int[31];

    }

    public void addSteps(int day, int steps) {
        days[day] = steps;
    }
}