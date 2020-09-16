package com.example.api.web.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customers")
@Api(value="onlinecustomers", description="Operations pertaining to customers in Online")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	
	@ApiOperation(value = "View a list of available customers", response = Customer.class)
	@GetMapping
	public List<Customer> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	@PostMapping
	public Customer create(@RequestBody @Valid Customer customer) {
		return service.create(customer);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Customer> update(@PathVariable("id") long id, @RequestBody @Valid Customer customer) {
		return service.update(id, customer);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Optional<?> delete(@PathVariable long id) {
		return service.delete(id);
	}
	
	
}
