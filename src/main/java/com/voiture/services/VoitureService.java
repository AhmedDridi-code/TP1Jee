package com.voiture.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.entities.Voiture;
import com.voiture.repositories.VoitureRepository;
@Service
@Transactional
public class VoitureService {
	@Autowired
	private VoitureRepository repo;
	
	public List<Voiture> listAll(){
		return repo.findAll();
	}
	public void save(Voiture voiture){
		repo.save(voiture);
	}
	public Voiture get(long id){
		return repo.findById(id).get();
	}
	public void delete(long id){
		repo.deleteById(id);
	}
	public void deleteAll(){
		repo.deleteAll();
	}
	
}
