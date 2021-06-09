package com.examples.spring.webflux.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.examples.spring.webflux.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

	private Map<Integer, Customer> customers = new HashMap<>();

	{

		customers.put(1, new Customer(1, "Anand","Chennai","India","TN","GGAESP1019H","SAVINGS"));
		customers.put(2, new Customer(2, "Shri","Hyd","India","TN","GGASKM1239H","CURRENT"));
		customers.put(3, new Customer(3, "Vidhya","Chennai","India","TN","DSFGSP2819H","SAVINGS"));
	}

	@Override
	public Flux<Customer> getAllCustomers() {
		return Flux.fromIterable(customers.values());
	}

	@Override
	public Mono<Customer> getCustomer(Integer empId) {
		return Mono.just(customers.get(empId));
	}

	@Override
	public Mono<Customer> createCustomer(Customer customer) {

		customers.put(customer.getId(), customer);
		return Mono.just(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	@Override
	public void deleteCustomer(Integer empId) {
		customers.remove(empId);
	}
	
	
	public void deleteAll() {
		customers.clear();
	}

}
