package uk.co.certait.jpa.model;

import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

	@Column(name = "forename", nullable = false)
	private String forename;

	@Column(name = "surname", nullable = false)
	private String surname;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orders;

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<Order> getOrders() {
		return Collections.unmodifiableSet(orders);
	}

	public void addOrder(Order order) {
		order.setCustomer(this);
		orders.add(order);
	}
}
