package bSystemProject.BankingSystem.Service;

import bSystemProject.BankingSystem.Model.Transaction;
import bSystemProject.BankingSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public String addTransaction(Transaction transaction){
        transactionRepository.save(transaction);
        return "Worked";
    }


}
