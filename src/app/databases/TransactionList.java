package app.databases;

import app.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionList {
    private static TransactionList instance = null;
    private final List<Transaction> transactionList;

    public TransactionList() {
        this.transactionList = new ArrayList<>();
    }

    public static synchronized TransactionList getInstance() {
        if (instance == null) instance = new TransactionList();

        return instance;
    }

    public void add(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    public List<Transaction> getTransactionList() {
        return this.transactionList;
    }
}
