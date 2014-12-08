package uk.co.certait.jpa.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uk.co.certait.jpa.repository.CustomerRepositoryCustom;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public void detach(Object entity) {
		entityManager.detach(entity);
	}
}
