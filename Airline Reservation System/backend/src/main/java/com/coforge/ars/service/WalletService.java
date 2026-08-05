package com.coforge.ars.service;

import java.math.BigDecimal;
import java.util.List;

import java.util.Optional;

import com.coforge.ars.model.Wallet;


public interface WalletService {
	boolean saveWallet(Wallet wallet);
	boolean updateWallet(Integer walletId,Wallet wallet);
	boolean deleteWalletById(Integer WalletId);
	Optional<Wallet> findByWalletId(Integer walletId);
	List<Wallet> findAllWallets();
	
	boolean addMoney(Integer customerId, Double amount);
	BigDecimal checkBalance(Integer customerId);

}
