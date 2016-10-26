package com.safeway.app.vaadin.rtpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.safeway.app.vaadin.rtpp.domain.Customer;
import com.safeway.app.vaadin.rtpp.domain.CustomerRepository;

@Component
public class AppRunner implements CommandLineRunner{

	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	protected CustomerRepository repository;
	
	public AppRunner(CustomerRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... args) throws Exception
	{
		/*
		// save a couple of customers
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
		 */
		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");

		// fetch an individual customer by ID
		Customer customer = repository.findOne(3L);
		log.info("Customer found with findOne(3L):");
		log.info("--------------------------------");
		log.info(customer.toString());
		log.info("");

		// fetch customers by last name
		log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
		log.info("--------------------------------------------");
		for (Customer alex : repository
				.findByLastNameStartsWithIgnoreCase("Zhou")) {
			log.info(alex.toString());
		}
		log.info("");
	}	
}

