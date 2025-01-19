package bSystemProject.BankingSystem.Service;

import bSystemProject.BankingSystem.Model.BankAccount;
import bSystemProject.BankingSystem.Model.InternalTransfer;
import bSystemProject.BankingSystem.Model.UserInfo;
import bSystemProject.BankingSystem.Repository.BankAccountRepository;
import bSystemProject.BankingSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<BankAccount> internalTransfer(InternalTransfer transferInfo){
        List<BankAccount> userAccounts = userRepository.findById(transferInfo.getUserId()).get().getBankAccounts();
        int acccountFromAmountEnough = -1;
        for(BankAccount bankAccount: userAccounts){
            if(bankAccount.getAccountType().equals(transferInfo.getAccountFrom())){
                if(bankAccount.getBalance() >= transferInfo.getTransferAmount()){
                    bankAccount.setBalance(bankAccount.getBalance()-transferInfo.getTransferAmount());
                    acccountFromAmountEnough +=1;
                }
            }
            if(bankAccount.getAccountType().equals(transferInfo.getAccountTo()) && acccountFromAmountEnough == 0){
                bankAccount.setBalance(bankAccount.getBalance() + transferInfo.getTransferAmount());
                Optional<UserInfo> opUser = userRepository.findById(transferInfo.getUserId());

                if (opUser.isPresent()) {
                    UserInfo user = opUser.get();
                    user.setBankAccounts(userAccounts);
                    userRepository.save(user);
                }
            }
        }
        return getUserAccounts(transferInfo.getUserId());
    }


    public BankAccount addBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
        return bankAccount;
    }
}
