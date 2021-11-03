package com.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.entities.Client;
import com.voiture.entities.Location;

public interface LocationRepository extends JpaRepository<Location,Long>, LocationRepositoryCustom {
	

}
