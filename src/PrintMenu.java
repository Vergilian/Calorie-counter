public class PrintMenu {
        public static void printMenu() {
        System.out.println("Чемпион, выбери что ты хочешь сделать:");
        System.out.println("1 - Ввести количество шагов за определённый день,");
        System.out.println("2 - Получить статистику за х-месяц,");
        System.out.println("3 - Ежедневная цель: " + StepTracker.purpose + " шагов. Хочешь её поменять?");
        System.out.println("4 - Завершить работу.");
    }
}