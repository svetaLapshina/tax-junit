package com.company.task16;

public class CreditAccount  extends Account {
    public CreditAccount(int balance) {
        super(balance);
    }

    public CreditAccount(int balance, String signature) {
        super(balance, signature);
    }

    @Override
    public void pay(int amount) throws InvalidOperationException {
        if (amount < 0)
            throw new InvalidOperationException("Недопустимая сумма платежа");
        else
            setBalance(getBalance() - amount);
    }

    @Override
    public void transfer(Account account, int amount) throws InvalidOperationException {
        throw new InvalidOperationException("Операция перевода для кредитного счета не поддерживается");
    }

    @Override
    public void addMoney(int amount) throws InvalidOperationException {
        if ((getBalance() + amount) > 0) {
            throw new InvalidOperationException("Баланс кредитного счета не может быть положительным");
        } else {
            setBalance(getBalance() + amount);
        }
    }
}
