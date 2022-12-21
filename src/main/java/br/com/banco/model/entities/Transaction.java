package br.com.banco.model.entities;

import br.com.banco.repositories.TransactionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Entity
@Table(name = "transferencia")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "data_transferencia")
    private Date transferDate;

    @Column(name = "valor")
    private Double value;

    @Column(name = "tipo")
    private String transactionType;

    @Column(name = "nome_operador_transacao")
    private String operatorName;


    @ManyToOne()
    @JoinColumn(name = "conta_id", referencedColumnName = "id_conta", nullable = false)
    private Account account;

    public Transaction() {
    }

    public Transaction(Integer id, Date transferDate, Double value, String transactionType, String operatorName, Account account) {
        this.id = id;
        this.transferDate = transferDate;
        this.value = value;
        this.transactionType = transactionType;
        this.operatorName = operatorName;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public Double getValue() {
        return value;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public Account getAccount() {
        return account;
    }

}