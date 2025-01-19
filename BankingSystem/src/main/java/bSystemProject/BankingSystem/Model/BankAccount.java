package bSystemProject.BankingSystem.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static bSystemProject.BankingSystem.Model.BankAccountStatus.ACTIVE;

@Data
@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer accountId;
    @Column(unique = true) private String accountNumber;
    private String accountType;
    private Double balance;
    private String accountNickname;
    private BankAccountStatus bankAccountStatus;
    @ManyToOne @JoinColumn(name = "user_id") @JsonBackReference private UserInfo user; // Many-to-One Relationship to User account
    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, orphanRemoval = true) private List<Transaction> transactions;

    public BankAccount(){

    }

    public BankAccount(String accountNumber, String accountType, UserInfo user) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.00;
        this.accountNickname = createAccountNickname(accountNumber, accountType);
        this.user = user;
        this.bankAccountStatus = ACTIVE;
    }

    public String createAccountNickname(String accountNumber, String accountType){
        int begIndex = accountNumber.length() - 4;
        int endIndex = accountNumber.length();
        String lastFourAccountNumber = accountNumber.substring(begIndex);
        return accountType + "(...." + lastFourAccountNumber + ")";
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountNickname() {
        return accountNickname;
    }

    public void setAccountNickname(String accountNickname) {
        this.accountNickname = accountNickname;
    }

    public BankAccountStatus getBankAccountStatus() {
        return bankAccountStatus;
    }

    public void setBankAccountStatus(BankAccountStatus bankAccountStatus) {
        this.bankAccountStatus = bankAccountStatus;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
