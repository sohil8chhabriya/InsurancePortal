package com.insurance.portal.java.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.portal.java.entity.*;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

	Policy findByUser(User u);

/*    List<Policy> findByUserId(Long i);*/

}
