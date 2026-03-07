// Day 5 – Classes and Objects (advanced class features)

public class ClassesDemo {

    // Inner class example
    static class BankAccount {
        private String owner;
        private double balance;

        // Parameterized constructor
        BankAccount(String owner, double initialBalance) {
            this.owner = owner;
            this.balance = initialBalance;
        }

        void deposit(double amount) {
            if (amount > 0)
                balance += amount;
        }

        void withdraw(double amount) {
            if (amount > 0 && amount <= balance)
                balance -= amount;
            else
                System.out.println("Insufficient funds or invalid amount.");
        }

        void printStatement() {
            System.out.printf("Owner: %-15s Balance: %.2f%n", owner, balance);
        }

        // toString override
        @Override
        public String toString() {
            return "BankAccount{owner='" + owner + "', balance=" + balance + "}";
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 5000.00);
        BankAccount acc2 = new BankAccount("Bob", 1200.00);

        acc1.deposit(2000);
        acc1.withdraw(500);
        acc2.withdraw(2000); // should print insufficient

        acc1.printStatement();
        acc2.printStatement();

        System.out.println(acc1);
    }
}
