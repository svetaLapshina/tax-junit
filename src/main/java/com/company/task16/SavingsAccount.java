package com.company.task16;

public class SavingsAccount extends Account {

    public SavingsAccount(int balance) {
        super(balance);
    }

    public SavingsAccount(int balance, String signature) {
        super(balance, signature);
    }

    @Override
    public void pay(int amount) throws InvalidOperationException {
        throw new InvalidOperationException("Платежи с сберегательного счета не поддерживаются");
    }

    @Override
    public void transfer(Account account, int amount) throws InvalidOperationException {
        if (this.getBalance() < amount) {
            throw new InvalidOperationException("Недостаточно средств для перевода");
        } else {
            account.addMoney(amount);
        }
    }

    @Override
    public void addMoney(int amount) throws InvalidOperationException {
        if (amount < 0)
            throw new InvalidOperationException("Недопустимая сумма пополнения");
        else
            setBalance(getBalance() + amount);
    }
}
