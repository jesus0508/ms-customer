package pe.com.project1.ms.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
	@Id
	private String id;
	private String names;
	private String surname;
	private String lastname;
	private String dni;
	private String email;
	private LocalDate birthdate;
	private String type;

	public Customer(Customer customer) {

	}

	public Customer update(Customer customer) {
		return new Customer(id, customer.getNames(), customer.getSurname(), customer.getLastname(),
				customer.getDni(), customer.getEmail(), customer.getBirthdate(), customer.getType());
	}
}
