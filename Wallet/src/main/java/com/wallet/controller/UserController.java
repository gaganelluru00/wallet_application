package com.wallet.controller;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dao.TransactionRepository;
import com.wallet.dao.UserRepository;
import com.wallet.model.AmountTransaction;
import com.wallet.model.Transaction;
import com.wallet.model.User;
import com.wallet.model.UserDetails;
import com.wallet.service.WalletServiceInterface;
import com.wallet.service.WalletServiceImpl;
import com.wallet.service.WalletServiceImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/transfer")
public class UserController {
	@Autowired
	WalletServiceImpl serviceImpl;
	
	
	
	

	@PostMapping("/add")
	public User createUserAccount(@RequestBody UserDetails u) {
		return serviceImpl.createAccount(u);
		}
	
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return serviceImpl.getAllUsers();
	}
	
	
	
	@PutMapping("/deposit")
	public User depositAmount(@RequestBody AmountTransaction at) {
		
		return serviceImpl.deposit(at);
	}
	
	
	@PutMapping("/withdraw")
	public User withdrawAmount(@RequestBody AmountTransaction at) {
		return serviceImpl.withdraw(at);
		
	}
	
	
	@PostMapping("/print")
	public List<Transaction> sendTransactions(@RequestBody AmountTransaction at) {
		return serviceImpl.getAllTransaction(at);
		
		}
	
	
	@PostMapping("/fund")
	public User fundTransfer(@RequestBody AmountTransaction at) {
		
		return serviceImpl.transferFund(at);
	}
	
	
	@PostMapping("/show")
	public User showBalance(@RequestBody AmountTransaction at) {
		return serviceImpl.showBalance(at);
	}
	
	
	@PostMapping("/login")
	public User loginValidation(@RequestBody AmountTransaction at) {
		return serviceImpl.loginCheck(at);
	}
	@PutMapping("/details")
	public User getDetails(@RequestBody AmountTransaction at) {
		return serviceImpl.getUserDetails(at);
	}
	@GetMapping("/transactions")
	public List<Transaction>getTransactions(@RequestBody AmountTransaction at){
		return null;
	}
	
	
	@PutMapping("/delete")
	public User deleteUser(@RequestBody AmountTransaction acc) {
		return serviceImpl.deleteAccount(acc);
	}
	@PostMapping("/update")
	public User updateDetails(@RequestBody UserDetails u) {
		return serviceImpl.updateAccount(u);
	}
}
