package com.voiture.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.voiture.entities.Location;

public class LocationRepositoryImp implements LocationRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;
	public List<Location> ListeLocationByClient(String client) {
		Query query = entityManager.createNativeQuery("SELECT l.* FROM Location l WHERE l.client.name = ?",Location.class);
		query.setParameter(1,client);
		// TODO Auto-generated method stub
		return (List<Location>) query.getResultList();

}
	public List<Location> ListeLocationByVoiture(String voiture) {
		Query query = entityManager.createNativeQuery("SELECT l.* FROM Location l WHERE l.voiture.serie = ?",Location.class);
		query.setParameter(1,voiture);
		// TODO Auto-generated method stub
		return (List<Location>) query.getResultList();

}
	}
