package bSystemProject.BankingSystem.Controller;

import bSystemProject.BankingSystem.Model.BankAccount;
import bSystemProject.BankingSystem.Model.InternalTransfer;
import bSystemProject.BankingSystem.Service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bank_account")
public class BankAccountController {

    @Autowired
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/Create_Account")
    public BankAccount createBankAccount(@RequestBody BankAccount bankAccount){
        return bankAccountService.addBankAccount(bankAccount);
    }

    @PostMapping("/internal_transfer")
    public List<BankAccount> internalTransfer(@RequestBody InternalTransfer transferInfo){
        return bankAccountService.internalTransfer(transferInfo);
    }

    @GetMapping("/{ID}")
    public List<BankAccount> getAccoutsByUserID(@PathVariable Integer ID){
        return bankAccountService.getUserAccounts(ID);
    }

}
