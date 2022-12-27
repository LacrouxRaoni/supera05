package br.com.banco.model.services;

import br.com.banco.controller.exception.TransactionException;

import br.com.banco.model.entities.Transaction;
import br.com.banco.repositories.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public String[] getAllService(Integer param) {
        List<Optional<Transaction>> account = transactionRepository.findAllByAccount_IdAcc(param);
        if (account.isEmpty())
            throw new TransactionException("Invalid accId");
        return convertToJson(account);
    }

    public String[] getByDate(String begin, String end) throws ParseException {
        List<Optional<Transaction>> account = convertStringToDate(begin, end, "");
        if (account.isEmpty())
            throw new TransactionException("Invalid date value");
        return convertToJson(account);
    }

    private List<Optional<Transaction>> convertStringToDate(String begin, String end, String operator) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = sdf.parse(begin);
        Date date2 = sdf.parse(end);
        if (operator.isEmpty())
            return transactionRepository.findAllByTransferDateBetween(date1, date2);
        return transactionRepository.findAllByTransferDateBetweenAndOperatorName(date1, date2, operator);
    }

    public String[] getByOperator(String operator) {
        List<Optional<Transaction>> account = transactionRepository.findAllByOperatorName(operator);
        if (account.isEmpty())
            throw new TransactionException("Invalid operator");
        return convertToJson(account);
    }

    public String[] getByAllReferences(String param1, String param2, String operator) throws ParseException {
        List<Optional<Transaction>> account = convertStringToDate(param1, param2, operator);
        if (account.isEmpty())
            throw new TransactionException("Invalid args");
        return convertToJson(account);
    }

    private String[] convertToJson(List<Optional<Transaction>> account) {
        ObjectMapper jsonObj = new ObjectMapper();
        String []jsonStr = new String[account.size()];

        try {
            for (int i = 0; i < account.size(); i++){
                jsonStr[i] = jsonObj.writeValueAsString(account.get(i).get());
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonStr;
    }
}
