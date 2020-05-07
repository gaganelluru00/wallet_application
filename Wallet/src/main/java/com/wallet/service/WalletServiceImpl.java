package com.wallet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.wallet.dao.TransactionRepository;
import com.wallet.dao.UserRepository;
import com.wallet.model.AmountTransaction;
import com.wallet.model.Transaction;
import com.wallet.model.User;
import com.wallet.model.UserDetails;

@Service
public class WalletServiceImpl implements WalletServiceInterface {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	User user=null;
	User rec=null;
	User userIncorrect=new User();
	Transaction trans=null;
	Transaction trans1=null;
	ArrayList<User> users=null;
	
	
	@Override
	public User createAccount(UserDetails u) {
		
		int c=userRepository.countByUsername(u.getUsername());
		int uId=userRepository.countByUserId(Long.parseLong(u.getUserId()));
		String accNum;
		
		
		if(c>=1||uId>=1) {
			return null;
		}
		
		else {
		LocalDateTime t=LocalDateTime.now();
		String accTime=t.toString();
		
		String acc="ACC"+User.accNum;
		List<User> allUsers=userRepository.findAll();
		if(allUsers.size()==0) {
			accNum=acc;
		}
		else {
		List<Integer>accNumber=new ArrayList<Integer>();
		for(User u1:allUsers) {
			accNumber.add(Integer.parseInt(u1.getAccountNumber().substring(3)));
		}
		Collections.sort(accNumber,Collections.reverseOrder());
		//String acc1="ACC"+User.accNum;
		accNum="ACC"+(accNumber.get(0)+1);
		}
		Long id=Long.parseLong(u.getUserId());
		user=new User(id,u.getEmail(),u.getMobile(),0,accTime,u.getAccountType(),accNum,u.getUsername(),u.getPassword());
		userRepository.save(user);
		return user;
		}
		
	}
	@Override
	public User getUserDetails(AmountTransaction at) {
		
		int count=userRepository.countByUsernameAndPassword(at.getUsername(), at.getPassword());
		if(count!=0) {
			user=userRepository.findByUsernameAndPassword(at.getUsername(), at.getPassword());
			return user;
		}
		else {
		return null;}
	}
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
	
	
	@Override
	public User deposit(AmountTransaction at) {
		
		int login=userRepository.countByUsernameAndPassword(at.getUsername(), at.getPassword());
		if(login==0) {
			userIncorrect.setUsername("Incorrect Username or Password");
			return userIncorrect;
		}
		else {
		LocalDateTime time=LocalDateTime.now();
		String stime=time.toString();
		String transId="TX"+stime;
		String type="Deposit";
		double transAmount=Double.parseDouble(at.getAmount());
		user=userRepository.findByUsernameAndPassword(at.getUsername(), at.getPassword());
		Long id=user.getUserId();
		
		double balance=user.getAccountBalance();
		balance=balance+Double.parseDouble(at.getAmount());
		String acc=user.getAccountNumber();
		trans=new Transaction(id,transId,stime,type,acc,"self-credit",Double.parseDouble(at.getAmount()),balance);
		
		//uRepo.delete(user);
		user.getTransactions().add(trans);
		 transactionRepository.save(trans);
		
		String ctime=user.getTime();
		userRepository.delete(user);
		user.setTime(ctime);
		user.setAccountBalance(balance);
		userRepository.save(user);
		//uRepo.updateBalance(balance, at.getUsername(), at.getPassword());
		//uRepo.updateBalance(balance, at.getUsername(), at.getPassword());
		
		return user;}
	}
	
	
	
	
	@Override
	public User withdraw(AmountTransaction at) {
		
		int login=userRepository.countByUsernameAndPassword(at.getUsername(), at.getPassword());
		if(login==0){
			userIncorrect.setUsername("Incorrect Username or Password");
			return userIncorrect;
		}
		user=userRepository.findByUsernameAndPassword(at.getUsername(), at.getPassword());
		Long id=user.getUserId();
		double balance=user.getAccountBalance();
		if(balance<=Double.parseDouble(at.getAmount())) {
			return null;
		}
		
		
		else {
			balance=balance-Double.parseDouble(at.getAmount());
		LocalDateTime time=LocalDateTime.now();
		String stime=time.toString();
		String transId="TX"+stime;
		String type="Withdraw";
		double transAmount=Double.parseDouble(at.getAmount());
		
		String acc=user.getAccountNumber();
		
		trans=new Transaction(id,transId,stime,type,acc,"self-debit",Double.parseDouble(at.getAmount()),balance);
		
		//uRepo.delete(user);
		user.getTransactions().add(trans);
		 transactionRepository.save(trans);
		
		String ctime=user.getTime();
		userRepository.delete(user);
		user.setTime(ctime);
		user.setAccountBalance(balance);
		userRepository.save(user);
		
		
		return user;
		}
	}
	
	
	
	@Override
	public List<Transaction> getAllTransaction(AmountTransaction at) {
		
		int c=userRepository.countByAccountNumberAndPassword( at.getAccNumber(),at.getPassword());
		if(c==0) {
			return null;
		}
		else {
	User use=userRepository.findByUsernameAndPasswordAndAccountNumber(at.getUsername(), at.getPassword(), at.getAccNumber());
		List<Transaction>transactions= transactionRepository.findByRecId(at.getAccNumber());
		//transactions.addAll(transactionRepository.findBySendId(at.getAccNumber()));
	
		return transactions;
		
		}
	}
	
	
	
	
	@Override
	public User transferFund(AmountTransaction at) {
		
		int login=userRepository.countByUsernameAndPassword(at.getUsername(), at.getPassword());
		int acount=userRepository.countByAccountNumber(at.getAccNumber());
		/*if(login==0){
			userIncorrect.setUsername("Incorrect Username or Password");
			return userIncorrect;
		}*/
		if(acount==0) {
			User incorrectAccount=new User();
			incorrectAccount.setAccountNumber("Incorrect account number");
			return incorrectAccount;
		}
		LocalDateTime time=LocalDateTime.now();
		String stime=time.toString();
		String transId="TX"+stime;
		String type="Fund Transfered";
		String type1="Fund Received";
		user=userRepository.findByUsernameAndPassword(at.getUsername(), at.getPassword());
		double balance=user.getAccountBalance();
		double transAmount=Double.parseDouble(at.getAmount());
		if(balance<=transAmount) {
			return null;
		}
		else {
		
		balance=balance-Double.parseDouble(at.getAmount());
		Long id=user.getUserId();
		String acc=user.getAccountNumber();
		String ctime=user.getTime();
		userRepository.delete(user);
		user.setTime(ctime);
		user.setAccountBalance(balance);
		
		
		
		
		
		String accN=at.getAccNumber();
		rec=userRepository.findByAccountNumber(accN);
		double balance1=rec.getAccountBalance();
		balance1=balance1+Double.parseDouble(at.getAmount());
		Long id1=rec.getUserId();
		String ctime1=rec.getTime();
		userRepository.delete(rec);
		rec.setTime(ctime1);
		rec.setAccountBalance(balance1);
		trans=new Transaction(id,transId,stime,type,acc,accN,Double.parseDouble(at.getAmount()),balance);
		user.getTransactions().add(trans);
		userRepository.save(user);
		userRepository.save(rec);
		
		
		// transactionRepository.save(trans);
		//trans1=new Transaction(id1,transId,stime,type1,accN,acc,Double.parseDouble(at.getAmount()),balance1);
	//	tRepo.save(trans1);
		return user;
		}
	}
	
	
	@Override
	public User loginCheck(AmountTransaction at) {
		
		int count=userRepository.countByUsernameAndPasswordAndAccountNumber(at.getUsername(), at.getPassword(), at.getAccNumber());
		if(count>0) {
			user=userRepository.findByUsernameAndPasswordAndAccountNumber(at.getUsername(), at.getPassword(), at.getAccNumber());
			return user;
		}
		else {
		return null;}
	}
	
	
	@Override
	public User deleteAccount(AmountTransaction acc) {
		
		user=userRepository.findByUsernameAndPassword(acc.getUsername(), acc.getPassword());
		userRepository.delete(user);
		return user;
	}
	
	
	
	@Override
	public User showBalance(AmountTransaction at) {
		int login=userRepository.countByUsernameAndPassword(at.getUsername(), at.getPassword());
		if(login==0){
			userIncorrect.setUsername("Incorrect Username or Password");
			return userIncorrect;
		}
		else {
		user=userRepository.findByUsernameAndPassword(at.getUsername(), at.getPassword());
		//userPass=user;
		return user;
		}
	}
	@Override
	public User updateAccount(UserDetails u) {
		user=userRepository.findByUsernameAndPassword(u.getUsername(), u.getPassword());
		String time=user.getTime();
		userRepository.delete(user);
		user.setEmail(u.getEmail());
		user.setMobile(u.getMobile());
		user.setPassword(u.getPassword());
		user.setTime(time);
		userRepository.save(user);
		return user;
		
	}

	
}
