package com.coforge.ars.service;

import java.math.BigDecimal;

import java.util.List;

import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ars.exception.WalletAlreadyExistsException;
import com.coforge.ars.exception.WalletNotFoundException;
import com.coforge.ars.model.Wallet;
import com.coforge.ars.repo.WalletRepo;



@Service
public class WalletServiceImpl implements WalletService {

	private WalletRepo repo;
	private Environment environment;

	public WalletServiceImpl(WalletRepo repo, Environment environment) {
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean saveWallet(Wallet wallet) {
		//customer_id is in tbl_wallet,It stores the user_id of a user whose role is CUSTOMER.
		if (repo.findByCustomerId(wallet.getCustomerId()).isPresent()) {
			throw new WalletAlreadyExistsException(
					environment.getProperty("wallet.invalid.exists"));
		}

		repo.save(wallet);
		return true;
	}

	@Override
	public boolean updateWallet(Integer walletId, Wallet wallet) {

		if (!repo.existsById(walletId)) {
			throw new WalletNotFoundException(
					environment.getProperty("wallet.invalid.notfound"));
		}

		wallet.setWalletId(walletId);
		repo.save(wallet);

		return true;
	}

	@Override
	public boolean deleteWalletById(Integer walletId) {

		if (!repo.existsById(walletId)) {
			throw new WalletNotFoundException(
					environment.getProperty("wallet.invalid.notfound"));
		}

		repo.deleteById(walletId);
		return true;
	}

	@Override
	public Optional<Wallet> findByWalletId(Integer walletId) {

		if (!repo.existsById(walletId)) {
			throw new WalletNotFoundException(
					environment.getProperty("wallet.invalid.notfound"));
		}

		return repo.findById(walletId);
	}

	@Override
	public List<Wallet> findAllWallets() {

		return (List<Wallet>) repo.findAll();
	}
	
	@Override
	public boolean addMoney(Integer customerId, Double amount) {

		Optional<Wallet> optional = repo.findByCustomerId(customerId);

		if (optional.isEmpty()) {
			throw new WalletNotFoundException(
					environment.getProperty("wallet.invalid.notfound"));
		}

		Wallet wallet = optional.get();

		wallet.setBalance(
				wallet.getBalance().add(BigDecimal.valueOf(amount))
		);
		repo.save(wallet);

		return true;
	}
	
	@Override
	public BigDecimal checkBalance(Integer customerId) {

		Optional<Wallet> optional = repo.findByCustomerId(customerId);

		if(optional.isEmpty()) {
			throw new WalletNotFoundException(
					environment.getProperty("wallet.invalid.notfound"));
		}
		return optional.get().getBalance();
	}

}