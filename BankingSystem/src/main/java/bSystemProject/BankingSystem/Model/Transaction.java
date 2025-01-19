package bSystemProject.BankingSystem.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_ID;
    private Date transaction_Date;
    private String transaction_description;
    private double amount;
    private transactionStatus transaction_Status;


    // Many-to-One Relationship to transactions
    @ManyToOne
    @JoinColumn(name = "accountId")
    @JsonBackReference
    private BankAccount bankAccount;

    public Transaction() {
    }

    public Transaction(Date transaction_Date, String transaction_description, double amount, transactionStatus transaction_Status) {
        this.transaction_Date = transaction_Date;
        this.transaction_description = transaction_description;
        this.amount = amount;
        this.transaction_Status = transaction_Status;
    }

    public int getTransaction_ID() {
        return transaction_ID;
    }

    public void setTransaction_ID(int transaction_ID) {
        this.transaction_ID = transaction_ID;
    }

    public Date getTransaction_Date() {
        return transaction_Date;
    }

    public void setTransaction_Date(Date transaction_Date) {
        this.transaction_Date = transaction_Date;
    }

    public String getTransaction_description() {
        return transaction_description;
    }

    public void setTransaction_description(String transaction_description) {
        this.transaction_description = transaction_description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public transactionStatus getTransaction_Status() {
        return transaction_Status;
    }

    public void setTransaction_Status(transactionStatus transaction_Status) {
        this.transaction_Status = transaction_Status;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
