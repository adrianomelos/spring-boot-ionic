package com.ionic.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ionic.api.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
