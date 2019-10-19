import java.util.Scanner;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    SavingsAccount (double savingsBalance, double annualInterestRate)
    {
        this.savingsBalance = savingsBalance;
        this.annualInterestRate = annualInterestRate;
    }

    public double calculateMonthlyInterest()
    {
        double interest = (savingsBalance * annualInterestRate) / 12.0;
        this.savingsBalance += interest;
        return this.savingsBalance;
    }

    public void modifyInterestRate(double annualInterestRate)
    {
        this.annualInterestRate = annualInterestRate;
    }

}
