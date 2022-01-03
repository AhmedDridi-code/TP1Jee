package com.voiture.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Location {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@Column(name="date_debut")
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date dateDebut;
@Column(name="date_retour")
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date dateRetour;

@Column(name="prix_jour")
private float prixJour;
@Column(name="prix")
private float prix;
@ManyToOne
@JoinColumn(name="client")
private Client client;
@ManyToOne
@JoinColumn(name="voiture")
private Voiture voiture;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public Date getDateRetour() {
	return dateRetour;
}
public void setDateRetour(Date dateRetour) {
	this.dateRetour = dateRetour;
}
public float getPrixJour() {
	return prixJour;
}
public void setPrixJour(float prixJour) {
	this.prixJour = prixJour;
}
public float getPrix() {
	return prix;
}
public void setPrix(float prix) {
	this.prix = prix;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Voiture getVoiture() {
	return voiture;
}
public void setVoiture(Voiture voiture) {
	this.voiture = voiture;
}


}