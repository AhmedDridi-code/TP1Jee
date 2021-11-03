package com.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.entities.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
