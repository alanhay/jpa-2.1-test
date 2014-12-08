package uk.co.certait.jpa.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import uk.co.certait.jpa.model.Customer;
import uk.co.certait.jpa.repository.AbstractBaseDatabaseTest;
import uk.co.certait.jpa.repository.CustomerRepository;

public class CustomerRepositoryImplTest extends AbstractBaseDatabaseTest {

	@Autowired
	private CustomerRepository repository;

	@Test
	public void testLoadCustomer() {
		Customer customer = repository.findOne(1L);
		assertNotNull(customer);
		assertEquals("John", customer.getForename());
		assertEquals("Smith", customer.getSurname());
		repository.detach(customer);
		
		try {
			assertEquals(2, customer.getOrders().size());
			fail();
		}
		catch(Exception e) {
			assertEquals(org.hibernate.LazyInitializationException.class, e.getClass());
		}
	}

	@Override
	public String[] getDataSetPaths() {
		return new String[] { "/data/customers.xml", "/data/orders.xml" };
	}
}
