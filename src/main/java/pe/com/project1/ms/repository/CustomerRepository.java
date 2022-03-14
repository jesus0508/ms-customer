package pe.com.project1.ms.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import pe.com.project1.ms.domain.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

}
