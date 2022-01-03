package com.voiture.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.entities.Modele;
import com.voiture.entities.Voiture;
import com.voiture.repositories.ModeleRepository;
import com.voiture.repositories.VoitureRepository;

@Service
@Transactional
public class ModeleService {
	@Autowired
	private ModeleRepository repo;
	
	public List<Modele> listAll(){
		return repo.findAll();
	}
	public void save(Modele modele){
		repo.save(modele);
	}
	public  Modele get(long id){
		return repo.findById(id).get();
	}
	public void delete(long id){
		repo.deleteById(id);
	}
	public void deleteAll(){
		repo.deleteAll();
	}

}


