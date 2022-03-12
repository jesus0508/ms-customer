package pe.com.project1.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.project1.ms.domain.Customer;
import pe.com.project1.ms.service.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Mono<Customer> create(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@GetMapping("/{id}")
	public Mono<Customer> findById(@PathVariable String id) {
		return customerService.findById(id);
	}

	@GetMapping
	public Flux<Customer> findAll() {
		return customerService.findAll();
	}

	@PutMapping("/{id}")
	public Mono<Customer> update(@RequestBody Customer customer, @PathVariable String id) {
		return customerService.update(customer, id);
	}
}
