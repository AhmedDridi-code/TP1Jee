package com.voiture.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.entities.Client;
import com.voiture.entities.Location;
import com.voiture.entities.Voiture;
import com.voiture.repositories.ClientRepository;
import com.voiture.repositories.LocationRepository;
import com.voiture.repositories.VoitureRepository;

@Service
@Transactional
public class LocationService {
	@Autowired
	private LocationRepository repo;
	private ClientRepository repoClient;
	private VoitureRepository repoVoiture;
	
	public Location findLocation(long id) {
		Location location = repo.findById(id).get();
		return location;
		
	}
	public List <Client> listClient() {
		List <Client> listClient=new ArrayList<Client>();
		if(repoClient.findAll().size()>1) {
			listClient = repoClient.findAll();
			
		}
		return listClient;
		
	}
	public List <Voiture> listVoiture() {
		
		List <Voiture> listVoiture = repoVoiture.findAll();
		return listVoiture;
	}
	public List<Location> listLocation(){
		List<Location> listLocation = repo.findAll();
		return listLocation;
	}
	public void saveLocation(Location location) {
		repo.save(location);
	}
	public void deleteLocation(long id) {
		repo.deleteById(id);
	}
	public void deleteAll() {
		repo.deleteAll();
	}
	
	

}
