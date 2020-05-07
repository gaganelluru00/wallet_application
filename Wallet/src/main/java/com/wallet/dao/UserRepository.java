package com.wallet.dao;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wallet.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByUsername(String username);
	User findByAccountNumber(String accNumber);
	User findByUserId(Long userId);
	//User findByAccountNumberAndPassword(String accountNumber,String password);
	User findByUsernameAndPasswordAndAccountNumber(String username,String password,String accountNumber);
	int countByUsername(String username);
	int countByUserId(long userId);
	int countByUsernameAndPassword(String username,String password);
	int countByAccountNumber(String accountNumber);
	int countByUsernameAndPasswordAndAccountNumber(String username,String password,String accountNumber);
	int countByAccountNumberAndPassword(String accountNumber,String password);
	//@Query("from AccountDetails where username=?1 and password=?2 ")
	User findByUsernameAndPassword(String username,String password);
	//@Modifying
	//@Query("update User a set a.accountBalance=:accountBalance where a.username=:username and a.password=:password")
	//void updateBalance(@Param("accountBalance")double amount,@Param("username")String username,@Param("password")String password);
}
