import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Enter a valid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Current Balance: ₹" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful: ₹" + amount);
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}


// Class to represent ATM Machine
class ATM {
    private BankAccount account;
    private Scanner sc;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    // Display Menu
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print(" Invalid input! Enter a number: ");
                sc.next(); // discard invalid input
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> performWithdraw();
                case 2 -> performDeposit();
                case 3 -> account.checkBalance();
                case 4 -> System.out.println(" Thank you for using the ATM!");
                default -> System.out.println("❌ Invalid choice! Please select 1–4.");
            }
        } while (choice != 4);
    }

    // Handle Withdraw
    private void performWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    // Handle Deposit
    private void performDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }
}
public class task3 {
    public static void main(String[] args) {
         // Create a bank account with initial balance
        BankAccount userAccount = new BankAccount(5000.0);

        // Connect ATM with account
        ATM atm = new ATM(userAccount);

        // Start ATM Menu
        atm.showMenu();
    }
    
}
