package com.voiture.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@Column(name="cin")
private Integer cin;
@Column(name="nom")
private String nom;

@Column(name="prenom")
private String prenom;
@OneToMany(mappedBy="client")
private List<Location> locations= new ArrayList<Location>();

}
