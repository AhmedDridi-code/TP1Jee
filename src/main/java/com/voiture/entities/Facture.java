package com.voiture.entities;

import java.util.List;

import javax.persistence.Entity;


public class Facture {
	private Long id;
	
	private double prixTotal;
	
	private List<Location> location;
	
	private List<Double> prixLocation;
	
	private Client client;

	public Long getId() {
		return id;
	}
	

	public Facture() {
	
	}


	public Facture(Long id, double prixTotal, List<Location> location, List<Double> prixLocation, Client client) {
		super();
		this.id = id;
		this.prixTotal = prixTotal;
		this.location = location;
		this.prixLocation = prixLocation;
		this.client = client;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	public List<Double> getPrixLocation() {
		return prixLocation;
	}

	public void setPrixLocation(List<Double> prixLocation) {
		this.prixLocation = prixLocation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
	

}
