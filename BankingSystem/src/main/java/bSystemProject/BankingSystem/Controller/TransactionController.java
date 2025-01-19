package bSystemProject.BankingSystem.Controller;

import bSystemProject.BankingSystem.Model.Transaction;
import bSystemProject.BankingSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping("/new_transaction")
    public String addTransaction(@RequestBody Transaction transaction){
        return transactionService.addTransaction(transaction);
    }

}
