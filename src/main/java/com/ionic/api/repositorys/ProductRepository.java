package com.ionic.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ionic.api.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
