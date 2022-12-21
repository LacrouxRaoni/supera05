package br.com.banco.repositories;

import br.com.banco.model.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Override
    Optional<Transaction> findById(Integer id);
}
