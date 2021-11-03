package com.voiture.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.voiture.entities.Voiture;

public class VoitureRepositoryImp implements VoitureRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;
	

	public List<Voiture> listeVoitureByModele(String marque) {
		Query query = entityManager.createNativeQuery("SELECT v.* FROM Voiture v WHERE v.modele.libelle = ?",Voiture.class);
		query.setParameter(1,marque);
		// TODO Auto-generated method stub
		return (List<Voiture>) query.getResultList();

}
}