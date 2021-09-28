package com.voiture.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voiture.entities.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long>, ClientRepositoryCustom {

}
