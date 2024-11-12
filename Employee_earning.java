// Define an interface
interface Employee {
    double earnings(double basic);

    double deductions(double basic);

    double bonus(double basic);
}

// Define Manager class implementing Employee interface
class Manager implements Employee {
    @Override
    public double earnings(double basic) {
        double da = 0.8 * basic;
        double hra = 0.15 * basic;
        return basic + da + hra;
    }

    @Override
    public double deductions(double basic) {
        return 0.12 * basic; // Assuming PF deduction
    }

    @Override
    public double bonus(double basic) {
        return 0; // Manager class does not implement bonus method
    }
}

// Define Substaff class extending Manager class
class Substaff extends Manager {
    @Override
    public double bonus(double basic) {
        return 0.5 * basic;
    }
}

public class Employee_earning {
    public static void main(String[] args) {
        // Taking basic salary input from the user
        double basicSalary = 50000;

        // Creating Substaff object
        Substaff substaff = new Substaff();

        // Calculating earnings, deductions, and bonus
        double earnings = substaff.earnings(basicSalary);
        double deductions = substaff.deductions(basicSalary);
        double bonus = substaff.bonus(basicSalary);

        // Displaying the results
        System.out.println("Earnings: " + earnings);
        System.out.println("Deductions: " + deductions);
        System.out.println("Bonus: " + bonus);
    }
}