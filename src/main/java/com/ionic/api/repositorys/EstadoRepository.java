package com.ionic.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ionic.api.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
