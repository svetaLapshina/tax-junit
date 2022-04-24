package com.company.task16;

public abstract class Account {
    private int balance = 0;
    private String signature;

    Account(int balance) {
        this.balance = balance;
        System.out.println("Создан новый счет, баланс: " + balance);
    }

    Account(int balance, String signature) {
        this.balance = balance;
        this.signature = signature;
        System.out.println("Создан новый " + signature + " счет, баланс: " + balance);
    }

    public int getBalance(){
        return balance;
    }

    protected void setBalance(int balance){
        this.balance = balance;
    }

    protected String getSignature() {
        return signature;
    }

    public abstract void pay(int amount) throws InvalidOperationException;
    public abstract void transfer(Account account, int amount) throws InvalidOperationException;
    public abstract void addMoney(int amount)  throws InvalidOperationException;
}
