import exceptions.*;

import java.util.*;

public class Bank implements IBank {
    private Map<String, Account> accounts;
    private Map<Integer, Client> clients;

    public Bank(Map<String, Account> accounts, Map<Integer, Client> client) {
        this.accounts = accounts;
        this.clients = client;
    }

    @Override
    public int getId(int nif) throws ClientNotFoundException {
        if (!clients.containsKey(nif)) {
            throw new ClientNotFoundException();

        }
        return clients.get(nif).getId();
    }

    @Override
    public Set<Account> getClientAccounts(int nif) throws ClientNotFoundException {

        int clientId = getId(nif);

        Set<Account> clientAccounts = new HashSet<>();

        for (Account account : accounts.values()) {
            if (account.getClientId() == clientId) {
                clientAccounts.add(account);
            }
        }

        return clientAccounts;
    }

    @Override
    public void withdraw(String iban, double amount) throws NotEnoughBalanceException, AccountNotFoundException {

        if (!accounts.containsValue(iban)) {
            throw new AccountNotFoundException();
        }

        accounts.get(iban).withdrawMoney(amount);

//        Account myAccount = accounts.get(iban);
//
//        if (myAccount.getBalance() < amount){
//            throw new NotEnoughBalanceException();
//        }
//        myAccount.setBalance(myAccount.getBalance() - amount);
    }



    public void makeAccount (String iban, int nif) throws AccountAlreadyExistException, ClientNotFoundException{
       int clientId = getId(nif);
        if (accounts.containsKey(iban)){
            throw new AccountAlreadyExistException();
        }

        accounts.put(iban, new Account(iban, clientId, 0));
    }

    public void removeAccount (String iban) throws AccountNotFoundException{
        if (!accounts.containsKey(iban)){
            throw new AccountNotFoundException();
        }

        accounts.remove(iban);

    }

    public int showAccountBalance (int nif) throws ClientNotFoundException{
        int clientId = getId(nif);

    }




    @Override
    public void transfer(String ibanOrigin, String ibanDestination, double amount) throws OriginAccountNotFOundException, DestinationAccountNotFoundException, NotEnoughBalanceException{

        if (!accounts.containsKey(ibanOrigin)){
            throw new OriginAccountNotFOundException();
        }else if (!accounts.containsKey(ibanDestination)){
            throw new DestinationAccountNotFoundException();
        }

        accounts.get(ibanOrigin).withdrawMoney(amount);

        accounts.get(ibanDestination).depositMoney(amount);
    }


    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Map<Integer, Client> getClients() {
        return clients;
    }

    public void setClients(Map<Integer, Client> client) {
        this.clients = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(accounts, bank.accounts) && Objects.equals(clients, bank.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts, clients);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "accounts=" + accounts +
                ", client=" + clients +
                '}';
    }


}
