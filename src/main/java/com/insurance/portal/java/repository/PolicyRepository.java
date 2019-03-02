package com.insurance.portal.java.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.portal.java.entity.*;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

	Policy findByUser(User u);

}
