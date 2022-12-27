package br.com.banco.controller;

import br.com.banco.controller.exception.TransactionException;
import br.com.banco.model.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private String[] acc;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/accId")
    @ResponseBody
    public ResponseEntity getAllByAcc(@RequestParam Integer param){
        try{
            acc = transactionService.getAllService(param);
            return ResponseEntity.status(HttpStatus.OK).body(acc);
        } catch (TransactionException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/date")
    @ResponseBody
    public ResponseEntity getByDate(@RequestParam String param1, String param2){
        try{
            acc = transactionService.getByDate(param1, param2);
            return ResponseEntity.status(HttpStatus.OK).body(acc);
        } catch (TransactionException | ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/operator")
    @ResponseBody
    public ResponseEntity<String[]> getOperator(@RequestParam String param){
        //try{
            acc = transactionService.getByOperator(param);
            return ResponseEntity.status(HttpStatus.OK).body(acc);
        //} catch (TransactionException e) {
         //   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        //}
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity getByAll(@RequestParam String param1, String param2, String param3) throws ParseException {
        try {
            acc = transactionService.getByAllReferences(param1, param2, param3);
            return ResponseEntity.status(HttpStatus.OK).body(acc);
        } catch (TransactionException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
