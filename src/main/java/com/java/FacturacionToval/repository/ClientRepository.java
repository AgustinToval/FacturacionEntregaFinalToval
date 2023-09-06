package com.java.FacturacionToval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.FacturacionToval.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
