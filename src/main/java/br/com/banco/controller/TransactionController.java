package br.com.banco.controller;

import br.com.banco.controller.exception.TransactionException;
import br.com.banco.model.dto.TransactionDto;
import br.com.banco.model.entities.Transaction;
import br.com.banco.model.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private String acc;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/accId")
    public ResponseEntity getAllByAcc(@RequestBody TransactionDto transactionDto){
        try{
            acc = transactionService.getAllService(transactionDto);
            return ResponseEntity.status(HttpStatus.OK).body(acc);
        } catch (TransactionException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/date")
    public ResponseEntity getByDate(@RequestBody TransactionDto transactionDto){
        try{
            acc = transactionService.getByDate(transactionDto);
            return ResponseEntity.status(HttpStatus.OK).body(acc);
        } catch (TransactionException | ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/operator")
    public ResponseEntity getOperator(@RequestBody TransactionDto transactionDto){
        try{
            acc = transactionService.getByOperator(transactionDto);
            return ResponseEntity.status(HttpStatus.OK).body(acc);
        } catch (TransactionException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
