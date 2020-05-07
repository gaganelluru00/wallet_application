package com.wallet.dao;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.*;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.model.User;

@RunWith(SpringRunner.class)

//@ActiveProfiles({"userJpa"})
//@ContextConfiguration(classes= {UserRepository.class})
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	 private ApplicationContext applicationContext;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	User user;
	
	
		
	
	@org.junit.jupiter.api.Test
	public void testSaveUser() {
		 user=getUser();
		User savedUser=entityManager.persist(user);
		User dbUser=userRepository.findByUsername(user.getUsername());
		
		assertEquals(dbUser, user);
	}
	
	
	@org.junit.jupiter.api.Test
	public void testUsernameAndPassword() {
		user=getUser();
		User savedUser=entityManager.persist(user);

		User dbUser=userRepository.findByUsernameAndPassword(savedUser.getUsername(), savedUser.getPassword());
		assertEquals(dbUser, user);
	}
	
	
	@org.junit.jupiter.api.Test
	public void testUsernameAndPasswordAndAccNumber() {
		user=getUser();
		User savedUser=entityManager.persist(user);
		User dbUser=userRepository.findByUsernameAndPasswordAndAccountNumber(user.getUsername(), user.getPassword(), user.getAccountNumber());
		assertEquals(dbUser, user);
	}
	
	
	@org.junit.jupiter.api.Test
	public void  testUserId() {
		user=getUser();
		User savedUser=entityManager.persist(user);
		User dbUser=userRepository.findByUserId(user.getUserId());
		assertEquals(dbUser, user);
	}
	
	
	@org.junit.jupiter.api.Test
	public void countByUsername() {
		user=getUser();
		User savedUser=entityManager.persist(user);
		int count=userRepository.countByUsername(user.getUsername());
		assertEquals(count,1);
	}
	
	
	@org.junit.jupiter.api.Test
	public void countByUsernamAndPassworde() {
		user=getUser();
		User savedUser=entityManager.persist(user);
		int count=userRepository.countByUsernameAndPassword(user.getUsername(),user.getPassword());
		assertEquals(count,1);
	}
	
	@org.junit.jupiter.api.Test
	public void countByUserId() {
		user=getUser();
		User savedUser=entityManager.persist(user);
		int count=userRepository.countByUserId(user.getUserId());
		assertEquals(count,1);
	}
	

	@org.junit.jupiter.api.Test
	public void countByUsernamAndPasswordeAndAccountNumber() {
		user=getUser();
		User savedUser=entityManager.persist(user);
		int count=userRepository.countByUsernameAndPasswordAndAccountNumber(user.getUsername(),user.getPassword(),savedUser.getAccountNumber());
		assertEquals(count,1);
	}
	
	public User getUser() {
		User user=new User();
		user.setAccountBalance(0);
		user.setTime(LocalDateTime.now().toString());
		user.setAccountNumber("ACC");
		user.setEmail("aaa");
		user.setMobile("9001");
		user.setUsername("abc");
		user.setPassword("abcabc");
		user.setAccountType("savings");
		user.setUserId(12345);
		
		
		return user;
	}
}
