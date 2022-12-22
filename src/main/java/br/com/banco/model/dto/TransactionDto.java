package br.com.banco.model.dto;

public class TransactionDto {

    private Integer accId;

    private String begin;

    private String end;

    private String operator;


    public TransactionDto() {
    }

    public TransactionDto(Integer accId) {
        this.accId = accId;
    }

    public TransactionDto(String begin, String end) {
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

    public Integer getAccId() {
        return accId;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public String getOperator() {
        return operator;
    }
}
