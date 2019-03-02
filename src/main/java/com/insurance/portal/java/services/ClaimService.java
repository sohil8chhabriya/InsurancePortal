package com.insurance.portal.java.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.portal.java.entity.Claim;
import com.insurance.portal.java.repository.ClaimRepository;

@Service
public class ClaimService {
	@Autowired
	private ClaimRepository claimRepository;
	
	@Autowired
	private PolicyService policyService;
	
	public boolean addClaim(String policyId, String claimAmount, String bills) {
		Claim claim = new Claim();
		claim.setPolicy(policyService.getPolicyDetails(policyId));
		claim.setClaimDocumentsCopies(bills);
		claim.setClaimAmount(Integer.parseInt(claimAmount));
		claim.setDateOfClaim(new Date().toString());
		Long claimId = claimRepository.save(claim).getClaimId();
		return (claimId != null);
	}

	public Claim getClaimDetails(String policyId) {
		return claimRepository.getClaimByPolicy(Integer.parseInt(policyId));
	}
	
	public List<Claim> getAllClaim() {
		return claimRepository.findAll();
	}
}
