package com.insurance.portal.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.portal.java.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
	
	Claim getClaimByPolicy(int policyId);

}
