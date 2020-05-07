package com.wallet;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.wallet.controller.*;
import com.wallet.dao.*;
import com.wallet.model.*;
//@EntityScan(basePackages="com.wallet.model")
//@EnableJpaRepositories(basePackages="com.wallet.dao")
@EnableJpaAuditing

@SpringBootApplication(scanBasePackages= {"com.wallet.service","com.wallet.controller","com.wallet.dao","com.wallet.model"})
public class WalletOracle implements CommandLineRunner {

	@Autowired
	private UserRepository uRepo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(WalletOracle.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
