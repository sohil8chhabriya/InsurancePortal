package com.insurance.portal.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.portal.java.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
