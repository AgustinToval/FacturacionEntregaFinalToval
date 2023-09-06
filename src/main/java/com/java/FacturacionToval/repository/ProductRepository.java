package com.java.FacturacionToval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.FacturacionToval.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
       List<Product> findAll();
}
