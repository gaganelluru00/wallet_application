package com.wallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EntityScan(basePackages="com.wallet.model")
//@EnableJpaRepositories(basePackages="com.wallet.dao")
//@SpringBootApplication
public class WalletProjectApplication {//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WalletProjectApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}*/

	

}
