public class MonthData {
    int[] monthDays = new int[31];

    public MonthData() {
    }

    public void addSteps(int day, int steps) {
        this.monthDays[day] = steps;
    }
}