package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public Customer create(Customer customer) {
		return repository.save(customer);
	}

	public ResponseEntity<Customer> update(Long id, Customer customer) {
		return repository.findById(id).map(record -> {
			record.setEmail(customer.getEmail());
			record.setName(customer.getName());
			Customer newCustomer = repository.save(record);
			return ResponseEntity.ok().body(newCustomer);
		}).orElse(ResponseEntity.notFound().build());

	}

	public Optional<?> delete(Long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		});
	}
}
