import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds for this withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    depositFunds(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdrawFunds(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }

    private void viewBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    private void depositFunds(double amount) {
        account.deposit(amount);
    }

    private void withdrawFunds(double amount) {
        account.withdraw(amount);
    }
}

// Main class to run the ATM interface
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00); // Initial balance
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}