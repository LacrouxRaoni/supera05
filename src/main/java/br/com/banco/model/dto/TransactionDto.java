package br.com.banco.model.dto;

import com.sun.istack.NotNull;

public class TransactionDto {

    @NotNull
    private Integer accId;

    private String begin;

    private String end;

    private String operator;


    public TransactionDto() {
    }

    public TransactionDto(Integer accId) {
        this.accId = accId;
    }

    public TransactionDto(Integer accId, String begin, String end) {
        this.accId = accId;
        this.begin = begin;
        this.end = end;
    }

    public TransactionDto(Integer accId, String operator) {
        this.accId = accId;
        this.operator = operator;
    }

    public TransactionDto(Integer accId, String begin, String end, String operator) {
        this.accId = accId;
        this.begin = begin;
        this.end = end;
        this.operator = operator;
    }
}
