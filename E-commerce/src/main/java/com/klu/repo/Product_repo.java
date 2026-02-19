package com.klu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.model.Product;

@Repository
public interface Product_repo extends JpaRepository<Product, Long> {

}
