import java.util.Scanner;

 class BankAccount {
    String name;
    int accountNumber;
    double balance;

    BankAccount(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposit successful. New balance: ₹" + balance);
        } else {
            System.out.println("❌ Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawal successful. New balance: ₹" + balance);
        } else {
            System.out.println("❌ Invalid or insufficient funds.");
        }
    }

    void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

class BankAccountManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[100];
        int count = 0;

        while (true) {
            System.out.println("\n🏦 BANK ACCOUNT MANAGEMENT SYSTEM");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Details");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    int accNum = sc.nextInt();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();

                    accounts[count] = new BankAccount(name, accNum, balance);
                    count++;
                    System.out.println("✅ Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depositNum = sc.nextInt();
                    boolean foundDeposit = false;
                    for (int i = 0; i < count; i++) {
                        if (accounts[i].accountNumber == depositNum) {
                            System.out.print("Enter amount to deposit: ");
                            double amount = sc.nextDouble();
                            accounts[i].deposit(amount);
                            foundDeposit = true;
                            break;
                        }
                    }
                    if (!foundDeposit) System.out.println("❌ Account not found.");
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawNum = sc.nextInt();
                    boolean foundWithdraw = false;
                    for (int i = 0; i < count; i++) {
                        if (accounts[i].accountNumber == withdrawNum) {
                            System.out.print("Enter amount to withdraw: ");
                            double amount = sc.nextDouble();
                            accounts[i].withdraw(amount);
                            foundWithdraw = true;
                            break;
                        }
                    }
                    if (!foundWithdraw) System.out.println("❌ Account not found.");
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int viewNum = sc.nextInt();
                    boolean foundView = false;
                    for (int i = 0; i < count; i++) {
                        if (accounts[i].accountNumber == viewNum) {
                            accounts[i].displayDetails();
                            foundView = true;
                            break;
                        }
                    }
                    if (!foundView) System.out.println("❌ Account not found.");
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("No accounts available.");
                    } else {
                        System.out.println("\n--- All Accounts ---");
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + accounts[i].name + " - ₹" + accounts[i].balance);
                        }
                    }
                    break;

                case 6:
                    System.out.println("👋 Exiting system. Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
