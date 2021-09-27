package com.voiture.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.voiture.entities.Client;

@Repository
@Transactional
public class ClientRepositoryImp1 implements ClientRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;
	public Client getClientByName(String name) {
		Query query = entityManager.createNativeQuery("SELECT c.* FROM Client c WHERE c.name LIKE ?",Client.class);
		query.setParameter(1,name +"%");
		// TODO Auto-generated method stub
		return (Client) query.getSingleResult();
	}

}
