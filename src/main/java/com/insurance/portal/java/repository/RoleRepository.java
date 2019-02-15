package com.insurance.portal.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.insurance.portal.java.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
}