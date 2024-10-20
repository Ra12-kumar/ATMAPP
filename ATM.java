import java.util.Scanner;

// Interface to define ATM operations
interface ATMOperations {
    void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
    void exit();
}

// ATM class implementing the ATMOperations interface
public class ATM implements ATMOperations {
    private double balance;

    // Constructor to initialize the ATM with an initial balance
    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    // Implementing the checkBalance() method
    @Override
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Implementing the deposit() method
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Implementing the withdraw() method
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Implementing the exit() method
    @Override
    public void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
        System.exit(0);
    }

    // Main method to run the ATM system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000);  // Initialize ATM with ₹1000

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    atm.exit();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
