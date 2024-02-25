import java.util.ArrayList;
import java.util.List;

class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", amount));
    }

    public void transfer(double amount, BankAccount recipient) throws InsufficientFundsException {
        withdraw(amount); 
        recipient.deposit(amount);
        transactionHistory.add(new Transaction("Transfer to " + recipient.getAccountNumber(), amount));
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction history for account " + accountNumber + ":");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getDescription() + ": $" + transaction.getAmount());
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(double initialBalance) {
        String accountNumber = generateAccountNumber();
        BankAccount account = new BankAccount(accountNumber, initialBalance);
        accounts.add(account);
        return account;
    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

public class OnlineBanking {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount account1 = bank.createAccount(4000);
        BankAccount account2 = bank.createAccount(2500);

        try {
            account1.deposit(400);
            account1.withdraw(2000);
            account1.transfer(250, account2);

            System.out.println("Account 1 Balance: $" + account1.getBalance());
            System.out.println("Account 2 Balance: $" + account2.getBalance());

            account1.displayTransactionHistory();
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
