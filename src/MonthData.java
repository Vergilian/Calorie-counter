public class MonthData {
    int [] monthDays= new int[31];

    MonthData() {

    }

    public void addSteps(int day, int steps) {
        monthDays[day] = steps;
    }
}