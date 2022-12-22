package br.com.banco.repositories;

import br.com.banco.model.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Optional<Transaction>> findAllByAccount_IdAcc(Integer id);

    List<Optional<Transaction>> findAllByTransferDateBetween(Date begin, Date end);
}
