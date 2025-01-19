package bSystemProject.BankingSystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static bSystemProject.BankingSystem.Model.UserStatus.ACTIVE;

@Data
@Entity
@Table(name = "user_info")
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)  // Exclude null fields in JSON
public class UserInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String userPassword;
    private UserStatus userStatus;
    private Date memberSince;
    private Date deactivationDate;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) private List<BankAccount> bankAccounts;  // One-to-Many Relationship to BankAccount


    public UserInfo(){

    }

    public UserInfo(String firstName, String lastName, String email, String userName, String userPassword, Date memberSince) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.userPassword = userPassword;
        this.memberSince = memberSince;
        this.userStatus = ACTIVE;
        this.deactivationDate = null;
        this.bankAccounts = new ArrayList<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
