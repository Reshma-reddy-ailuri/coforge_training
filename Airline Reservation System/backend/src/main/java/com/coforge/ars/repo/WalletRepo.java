package com.coforge.ars.repo;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ars.model.Wallet;


@Repository
public interface WalletRepo extends CrudRepository<Wallet, Integer>{
	Optional<Wallet> findByCustomerId(Integer customerId);
}
