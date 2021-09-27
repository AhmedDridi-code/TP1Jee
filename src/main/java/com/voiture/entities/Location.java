package com.voiture.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Location {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@Column(name="date_debut")
private Date dateDebut;
@Column(name="date_retour")
private Date date_retour;

@Column(name="prix_jour")
private float prixJour;
@Column(name="prix")
private float prix;
@ManyToOne
@JoinColumn(name="client")
private Location client;
@ManyToOne
@JoinColumn(name="voiture")
private Voiture voiture;


}