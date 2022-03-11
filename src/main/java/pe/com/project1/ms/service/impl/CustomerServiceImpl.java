package pe.com.project1.ms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.project1.ms.domain.Customer;
import pe.com.project1.ms.repository.CustomerRepository;
import pe.com.project1.ms.service.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Mono<Customer> save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Mono<Customer> findById(String id) {
		return customerRepository.findById(id);
	}

	@Override
	public Flux<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Mono<Customer> update(Customer customer, String id) {
		return this.findById(id)
				.map(c -> c.update(customer))
				.flatMap(c -> this.save(c));
	}

}
