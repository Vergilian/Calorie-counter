public class MonthData {
    int [] days = new int[31];

    MonthData() {

    }

    public void addSteps(int day, int steps) {
        days[day] = steps;
    }
}