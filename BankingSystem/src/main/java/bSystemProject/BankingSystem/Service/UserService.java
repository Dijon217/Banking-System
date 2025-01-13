package bSystemProject.BankingSystem.Service;


import bSystemProject.BankingSystem.Module.BankAccount;
import bSystemProject.BankingSystem.Module.UserInfo;
import bSystemProject.BankingSystem.Repository.BankAccountRepository;
import bSystemProject.BankingSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;

    public UserService(UserRepository userRepository, BankAccountRepository bankAccountRepository) {
        this.userRepository = userRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }

    public String deleteUserID(Integer ID) {
        userRepository.deleteById(ID);
        return userRepository.existsById(ID) ? "User was not deleted" : "User was deleted successfully!";
    }

    public String createUser(UserInfo userInfo){
        userRepository.save(userInfo);
        UserInfo tempUser = userRepository.getReferenceById(userInfo.getUserId());
        return userInfo.equals(tempUser) ? "User Created Successfully!" : "User was not created";
    }

    public Optional<UserInfo> getUserNameById(Integer id) {
        return userRepository.findById(id);
    }

    public UserInfo saveUserWithBankAccounts(UserInfo user) {
        // Set the user for each bank account
        for (BankAccount bankAccount : user.getBankAccounts()) {
            bankAccount.setUser(user);
        }
        // Save the user (this will also save the bank accounts due to CascadeType.ALL)
        return userRepository.save(user);
    }
}
