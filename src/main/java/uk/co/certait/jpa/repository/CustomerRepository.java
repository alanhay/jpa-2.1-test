package uk.co.certait.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import uk.co.certait.jpa.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>, CustomerRepositoryCustom{
	
}
