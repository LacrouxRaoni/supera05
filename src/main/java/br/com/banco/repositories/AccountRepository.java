package br.com.banco.repositories;

import br.com.banco.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findAccountByIdAcc(Integer accId);
}
