package com.klu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Product, Integer> {
}