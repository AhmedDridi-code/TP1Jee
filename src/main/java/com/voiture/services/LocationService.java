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
	
	public Location get(long id) {
		Location location = repo.findById(id).get();
		return location;
		
	}

	public List<Location> listAll(){
		List<Location> listLocation = repo.findAll();
		return listLocation;
	}
	public void save(Location location) {
		repo.save(location);
	}
	public void delete(long id) {
		repo.deleteById(id);
	}
	public void deleteAll() {
		repo.deleteAll();
	}
	
	

}
