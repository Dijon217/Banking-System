package bSystemProject.BankingSystem.Controller;

import bSystemProject.BankingSystem.Module.BankAccount;
import bSystemProject.BankingSystem.Service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/bank_account")
public class BankAccountController {

    @Autowired
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/{ID}")
    public List<BankAccount> getAccoutsByUserID(@PathVariable Integer ID){
        return bankAccountService.getUserAccounts(ID);
    }

}
