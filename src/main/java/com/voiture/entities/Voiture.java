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
public class Voiture {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@Column(name="serie")
private String serie;
@Column(name="date_mise_en_marche")
private Date dateMiseEnMarche;

@Column(name="modele")
private String modele;
@OneToMany(mappedBy="voiture")
private List<Location> locations= new ArrayList<Location>();

}
