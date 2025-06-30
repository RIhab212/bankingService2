package service;

import model.Transaction;

import java.util.*;

public class Account implements AccountService {
    private int balance = 0;
    private List<Transaction> transactions = new ArrayList<>();
    private boolean lastWithdrawSuccessful = false;
    public boolean wasLastWithdrawSuccessful() {


        return lastWithdrawSuccessful;
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du dépôt doit être positif.");
        }
        balance += amount;
        transactions.add(new Transaction(getTodayDate(), amount, balance));
    }


    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            lastWithdrawSuccessful = false;
            throw new IllegalArgumentException("Le montant du retrait doit être positif.");
        }
        if (amount > balance) {
            lastWithdrawSuccessful = false;
            throw new IllegalStateException("Solde insuffisant pour effectuer le retrait.");
        }
        balance -= amount;
        transactions.add(new Transaction(getTodayDate(), -amount, balance));
        lastWithdrawSuccessful = true;
    }



    @Override
    public void printStatement() {
        System.out.println("Date       || Amount || Balance");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            System.out.printf("%s || %6d || %7d\n", t.getDate(), t.getAmount(), t.getBalance());
        }
    }

    private String getTodayDate() {
        return java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
