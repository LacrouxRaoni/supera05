package br.com.banco.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conta")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_conta")
    private Integer idAcc;

    @Column(name = "nome_responsavel")
    private String name;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private final static List<Transaction> transaction = new ArrayList<>();

    public Account() {
    }

    public Account(Integer idAcc, String name) {
        this.idAcc = idAcc;
        this.name = name;
    }

    public Integer getIdAcc() {
        return idAcc;
    }

    public String getName() {
        return name;
    }



}
