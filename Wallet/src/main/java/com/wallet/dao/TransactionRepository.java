package com.wallet.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	List<Transaction> findByRecId(String recId);
	List<Transaction>findBySendId(String sendId);

	//List<Transaction> findByRecIdOrSendId(String accountNumber);

}
