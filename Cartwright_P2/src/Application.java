public class Application {
    public static void main(String[] args) {
        double balance1, balance2;
        int i;
        SavingsAccount saver1 = new SavingsAccount(2000.00, .04);
        SavingsAccount saver2 = new SavingsAccount(3000.00, .04);

        System.out.println("Month\t  saver1\t    saver2");
        for(i = 0; i < 12; i++)
        {
            balance1 = saver1.calculateMonthlyInterest();
            balance2 = saver2.calculateMonthlyInterest();
            System.out.printf("%-9d$%-13.2f$%-13.2f\n", (i + 1), balance1, balance2);
        }

        System.out.println("\nChanging annual interest rate to 5.0%\n");

        balance1 = saver1.calculateMonthlyInterest();
        balance2 = saver2.calculateMonthlyInterest();

        System.out.println("Month\t  saver1\t    saver2");
        System.out.printf("%-9d$%-13.2f$%-13.2f\n", (i + 1), balance1, balance2);
    }
}
