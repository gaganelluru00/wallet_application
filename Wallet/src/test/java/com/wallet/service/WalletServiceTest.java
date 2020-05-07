package com.wallet.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.dao.UserRepository;
import com.wallet.model.AmountTransaction;
import com.wallet.model.User;
import com.wallet.model.UserDetails;


@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
public class WalletServiceTest {

	
	@Autowired
	private WalletServiceImpl walletServiceImpl;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void testCreateAccount() {
		User user=getUser();
		UserDetails userDetails=getUserDetails();
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals(walletServiceImpl.createAccount(userDetails).getUserId(), user.getUserId());
	}
	
	@Test
	public void testGetUserDetails() {
		User user=getUser();
		UserDetails userDetails=getUserDetails();
		AmountTransaction at=getDetails();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		at.setUsername(user.getUsername());
		at.setPassword(user.getPassword());
		
		
assertEquals(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()),walletServiceImpl.getUserDetails(at));
	}
	
	
	@Test
	public void testDeposit() {
		User user=getUser();
		AmountTransaction at=getDetails();
		Mockito.when(userRepository.countByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(1);
		Mockito.when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);
		
		at.setUsername(user.getUsername());
		at.setPassword(user.getPassword());
		at.setAmount("200");
		
	    
	User dbUser=walletServiceImpl.deposit(at);
	user.setAccountBalance(200);
	assertEquals(user, dbUser);
		
		
	}
	@Test
	public void testWithdraw() {
		User user=getUser();
		user.setAccountBalance(400);
		AmountTransaction at=getDetails();
		Mockito.when(userRepository.countByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(1);
		Mockito.when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);
		
		at.setUsername(user.getUsername());
		at.setPassword(user.getPassword());
		at.setAmount("200");
		
	    
	User dbUser=walletServiceImpl.withdraw(at);
	
	user.setAccountBalance(200);
	assertEquals(user, dbUser);
	}
	
	@Test
	public void testFundTransfer() {
		User user=getUser();
		User user1=getUser();
		user.setAccountBalance(500);
		user1.setUsername("aaa");
		user1.setPassword("aaabbb");
		user1.setAccountNumber("ACC2");
		AmountTransaction at=getDetails();
		at.setUsername(user.getUsername());
		at.setPassword(user.getPassword());
		at.setAccNumber(user1.getAccountNumber());
		at.setAmount("200");
		Mockito.when(userRepository.countByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(1);
		Mockito.when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);
		Mockito.when(userRepository.countByAccountNumber(user1.getAccountNumber())).thenReturn(1);
		Mockito.when(userRepository.findByAccountNumber(user1.getAccountNumber())).thenReturn(user1);
		User dbUser=walletServiceImpl.transferFund(at);
		assertEquals(dbUser.getAccountBalance(), 300);
		assertEquals(user1.getAccountBalance(), 200);
		
	}
	@Test
	public void testLoginCheck() {
		User user=getUser();
		Mockito.when(userRepository.findByUsernameAndPasswordAndAccountNumber(user.getUsername(), user.getPassword(), user.getAccountNumber())).thenReturn(user);
		Mockito.when(userRepository.countByUsernameAndPasswordAndAccountNumber(user.getUsername(),user.getPassword(), user.getAccountNumber())).thenReturn(1);
		AmountTransaction at=getDetails();
		at.setAccNumber("ACC1");
		assertEquals(walletServiceImpl.loginCheck(at), user);
	
	}
	@Test void testUpdate() {
		User user=getUser();
		Mockito.when(userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(user);
		UserDetails userDetails=getUserDetails();
		userDetails.setEmail("aaabbb");
		userDetails.setMobile("8001");
		User updatedUser=walletServiceImpl.updateAccount(userDetails);
		assertEquals(user.getEmail(), userDetails.getEmail());
		assertEquals(user.getMobile(), userDetails.getMobile());
		
		
	}
	
	
	
	public User getUser() {
		User user=new User();
		user.setAccountBalance(0);
		user.setTime(LocalDateTime.now().toString());
		user.setAccountNumber("ACC1");
		user.setEmail("aaa");
		user.setMobile("9001");
		user.setUsername("abc");
		user.setPassword("abcabc");
		user.setAccountType("savings");
		user.setUserId(12345);
		
		
		return user;
	}
	public UserDetails getUserDetails() {
		UserDetails userDetails=new UserDetails();
		userDetails.setUsername("abc");
		userDetails.setPassword("abcabc");
		userDetails.setAccountType("savings");
		userDetails.setUserId("12345");
		userDetails.setEmail("aaa");
		userDetails.setMobile("9001");
		
		return userDetails;
	}
	public AmountTransaction getDetails() {
		
		AmountTransaction at=new AmountTransaction();
		at.setUsername("abc");
		at.setPassword("abcabc");
	return at;
	}
}
