package com.company.task16;

public class Main {

    private static void testPay(Account account, int amount) {
        try {
            System.out.println("Списание со счета " + account.getSignature() + " суммы " + amount);
            System.out.println("Начальный баланс: " + account.getBalance());
            account.pay(amount);
        } catch (InvalidOperationException ex) {
            System.out.println("Ошибка! " + ex.getMessage());
        }

        System.out.println("Конечный баланс: " + account.getBalance() + "\n");
    }

    private static void testAddMoney(Account account, int amount) {
        try {
            System.out.println("Пополнение счета " + account.getSignature() + " на " + amount);
            System.out.println("Начальный баланс: " + account.getBalance());
            account.addMoney(amount);
        } catch (InvalidOperationException ex) {
            System.out.println("Ошибка! " + ex.getMessage());
        }

        System.out.println("Конечный баланс: " + account.getBalance() + "\n");
    }

    private static void testTransfer(Account accountFrom, Account accountTo, int amount) {
        try {
            System.out.println("Перевод со счета " + accountFrom.getSignature() + " на счет " + accountTo.getSignature() + " суммы " + amount);
            System.out.println("Начальный баланс счета " + accountFrom.getSignature() + ": " + accountFrom.getBalance());
            System.out.println("Начальный баланс счета " + accountTo.getSignature() + ": " + accountTo.getBalance());
            accountFrom.transfer(accountTo, amount);
        } catch (InvalidOperationException ex) {
            System.out.println("Ошибка! " + ex.getMessage());
        }
        System.out.println("Конечный баланс счета " + accountFrom.getSignature() + ": " + accountFrom.getBalance());
        System.out.println("Конечный баланс счета " + accountTo.getSignature() + ": " + accountTo.getBalance() + "\n");
    }


    public static void main(String[] args) throws InvalidOperationException {
        Account savingsAccount = new SavingsAccount(1_000_000, "Сберегательный");
        Account creditAccount = new CreditAccount(0, "Кредитный");
        Account checkingAccount = new CheckingAccount(1_000_000, "Расчетный");

        testAddMoney(creditAccount, 50_000);
        testPay(creditAccount,50_000);
        testTransfer(savingsAccount, creditAccount, 100_000);

        testTransfer(checkingAccount, creditAccount, 110_000);
        testTransfer(checkingAccount, creditAccount, 10_000);

    }
}
