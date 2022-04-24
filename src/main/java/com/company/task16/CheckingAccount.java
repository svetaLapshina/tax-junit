package com.company.task16;

public class CheckingAccount  extends Account {
    public CheckingAccount(int balance) {
        super(balance);
    }

    public CheckingAccount(int balance, String signature) {
        super(balance, signature);
    }

    @Override
    public void pay(int amount) throws InvalidOperationException {
        if (getBalance() < amount) {
            throw new InvalidOperationException(getSignature() + ": недостаточно средств для платежа");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    @Override
    public void transfer(Account account, int amount) throws InvalidOperationException {
        if (getBalance() < amount) {
            throw new InvalidOperationException("Недостаточно средств для перевода");
        } else {
            account.addMoney(amount);
            setBalance(getBalance() - amount);
        }
    }

    @Override
    public void addMoney(int amount) throws InvalidOperationException {
        if (amount < 0)
            throw new InvalidOperationException("Недопустимая сумма пополнения");
        else
            setBalance(this.getBalance() + amount);
    }
}
