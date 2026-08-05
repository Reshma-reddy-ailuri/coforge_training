package com.coforge.ars.controller;

import java.math.BigDecimal;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.ars.model.Wallet;
import com.coforge.ars.service.WalletService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/customer")
public class WalletController {

	private WalletService service;
	private Environment environment;

	@Autowired
	public WalletController(WalletService service, Environment environment) {
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/wallets")
	public ResponseEntity<String> saveWallet(@Valid @RequestBody Wallet wallet) {

		service.saveWallet(wallet);

		return new ResponseEntity<>(
				environment.getProperty("wallet.save.success"),
				HttpStatus.CREATED);
	}

	@PutMapping("/wallets/{walletId}")
	public ResponseEntity<String> updateWallet(@PathVariable Integer walletId,
			@Valid @RequestBody Wallet wallet) {

		service.updateWallet(walletId, wallet);

		return new ResponseEntity<>(
				environment.getProperty("wallet.update.success"),
				HttpStatus.OK);
	}

	@DeleteMapping("/wallets/{walletId}")
	public ResponseEntity<String> deleteWallet(@PathVariable Integer walletId) {

		service.deleteWalletById(walletId);

		return new ResponseEntity<>(
				environment.getProperty("wallet.delete.success"),
				HttpStatus.OK);
	}

	@GetMapping("/wallets/{walletId}")
	public ResponseEntity<Wallet> findByWalletId(@PathVariable Integer walletId) {

		Optional<Wallet> wallet = service.findByWalletId(walletId);

		return new ResponseEntity<>(
				wallet.get(),
				HttpStatus.OK);
	}

	@GetMapping("/wallets")
	public ResponseEntity<List<Wallet>> findAllWallets() {

		return new ResponseEntity<>(
				service.findAllWallets(),
				HttpStatus.OK);
	}
	
	@PutMapping("/wallets/addmoney/{customerId}/{amount}")
	public ResponseEntity<String> addMoney(@PathVariable Integer customerId,
			@PathVariable Double amount) {

		service.addMoney(customerId, amount);

		return new ResponseEntity<>(
		        environment.getProperty("wallet.addmoney.success"),
		        HttpStatus.OK);
	}
	@GetMapping("/wallets/balance/{customerId}")
	public ResponseEntity<BigDecimal> checkBalance(@PathVariable Integer customerId) {

		return new ResponseEntity<>(
				service.checkBalance(customerId),
				HttpStatus.OK);
	}
}