package com.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wallet.model.AmountTransaction;
import com.wallet.model.Transaction;
import com.wallet.model.User;
import com.wallet.model.UserDetails;

@Service
public interface WalletServiceInterface {

	public User createAccount(UserDetails u); 
	public User getUserDetails(AmountTransaction at);
	public List<User> getAllUsers();
	public User deposit(AmountTransaction at);
	public User withdraw(AmountTransaction at);
	public List<Transaction> getAllTransaction(AmountTransaction at);
	public User transferFund(AmountTransaction at);
	public User loginCheck(AmountTransaction at);
	public User deleteAccount(AmountTransaction at);
	public User showBalance(AmountTransaction at);
	public User updateAccount(UserDetails u);
}
