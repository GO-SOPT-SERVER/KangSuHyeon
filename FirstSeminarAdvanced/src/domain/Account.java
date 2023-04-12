package domain;
public class Account {
    private int account;
    private int password;
    private int balance;
    public Account(int account, int password, int balance) {
        this.account = account;
        this.password = password;
        this.balance = 0;
    }

    public boolean checkPassword(int password) {
        return password == this.password;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

}
