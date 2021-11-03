package com.voiture.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.entities.Client;
import com.voiture.entities.Voiture;
import com.voiture.repositories.ClientRepository;

@Service
@Transactional
public class ClientService {
	@Autowired
	private ClientRepository repo;
	
	public List<Client> listAll(){
		return repo.findAll();
	}
	public void save(Client client){
		repo.save(client);
	}
	public Client get(long id){
		return repo.findById(id).get();
	}
	public void delete(long id){
		repo.deleteById(id);
	}
	public void deleteAll(){
		repo.deleteAll();
	}

}
