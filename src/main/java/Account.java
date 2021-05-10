import exceptions.AccountNotFoundException;
import exceptions.ClientNotFoundException;
import exceptions.NotEnoughBalanceException;

import java.util.Objects;

public class Account {
    private String iban;
    private int clientId;
    private double balance;

    public Account(String iban, int clientId, double balance) {
        this.iban = iban;
        this.clientId = clientId;
        this.balance = balance;
    }

    public void withdrawMoney(double amount) throws NotEnoughBalanceException {
        if (balance < amount){
            throw new NotEnoughBalanceException();
        }
        balance = balance - amount;
    }

    public void depositMoney(double amount){
        balance = balance + amount;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return clientId == account.clientId && Double.compare(account.balance, balance) == 0 && Objects.equals(iban, account.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, clientId, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", clientId=" + clientId +
                ", balance=" + balance +
                '}';
    }
}
