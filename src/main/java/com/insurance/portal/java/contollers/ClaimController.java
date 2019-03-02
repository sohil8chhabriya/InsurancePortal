package com.insurance.portal.java.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.portal.java.entity.Claim;
import com.insurance.portal.java.services.ClaimService;

@RestController
@RequestMapping(headers = "Accept=application/json", produces = "application/json")
public class ClaimController {
	@Autowired
	private ClaimService claimService;

	@RequestMapping(method=RequestMethod.GET, value="/claim/{policyId}/{claimAmount}/{bills}")
	public boolean addClaim(@PathVariable String policyId, @PathVariable String claimAmount, @PathVariable String bills) {
		System.out.println("*************************Claim is getting added");
		return claimService.addClaim(policyId, claimAmount, bills);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/claim/")
	public List<Claim> getClaims() {
		System.out.println("*************************fetching All claims");
		return claimService.getAllClaim();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/claim/{policyId}")
	public Claim getClaimDetails(@RequestBody String policyId) {
		System.out.println("*************************Claim is getting fetched for policyId: "+policyId);
		return claimService.getClaimDetails(policyId);
	}

}
