package com.ionic.api.resouces.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ionic.api.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
