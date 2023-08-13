package com.example.pos.repository;

import com.example.pos.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products_Repository extends JpaRepository<Products,Integer> {
}
