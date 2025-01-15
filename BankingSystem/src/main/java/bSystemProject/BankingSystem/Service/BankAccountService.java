package bSystemProject.BankingSystem.Service;

import bSystemProject.BankingSystem.Module.BankAccount;
import bSystemProject.BankingSystem.Repository.BankAccountRepository;
import bSystemProject.BankingSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository, UserRepository userRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
    }

    public List<BankAccount> getUserAccounts(Integer userID){
        return userRepository.findById(userID).get().getBankAccounts();
    }



}
