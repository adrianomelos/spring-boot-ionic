package com.ionic.api.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ionic.api.entity.TermsUse;

@Repository
public interface TermsUseRepository extends JpaRepository<TermsUse, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM `tb_terms_use` WHERE id ORDER by id DESC limit 1")
	Optional<TermsUse> findTermsUse();


}
