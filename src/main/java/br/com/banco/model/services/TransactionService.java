package br.com.banco.model.services;

import br.com.banco.model.entities.Transaction;
import br.com.banco.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void teste(){
        Optional<Transaction> transaction = transactionRepository.findTransactionById(3);
        System.out.println(transaction.get().getTransactionType());
        System.out.println(transaction.get().getValue());

    }
}
