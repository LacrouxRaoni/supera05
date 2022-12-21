package br.com.banco.model.services;

import br.com.banco.controller.exception.TransactionException;
import br.com.banco.model.dto.TransactionDto;
import br.com.banco.model.entities.Transaction;
import br.com.banco.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public String getAllService(TransactionDto transactionDto) {
        List<Optional<Transaction>> account = transactionRepository.findAllByAccount_IdAcc(transactionDto.getAccId());
        if (account.isEmpty())
            throw new TransactionException("Invalid accId");
        return convertToString(account);
    }

    private String convertToString(List<Optional<Transaction>> account) {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append("\naccId= ");
        sb.append(account.get(0).get().getAccount().getIdAcc() + "\n");
        for (Optional<Transaction> c : account) {
            sb.append("date= ");
            sb.append(c.get().getTransferDate() + "\n");
            sb.append("type= ");
            sb.append(c.get().getTransactionType() + "\n");
            sb.append("value= ");
            sb.append(c.get().getValue() + "\n");
            sb.append("operator= ");
            sb.append(c.get().getOperatorName() + "\n");
        }
        sb.append("}\n");
        sb.append("}");
        return sb.toString();
    }
}
