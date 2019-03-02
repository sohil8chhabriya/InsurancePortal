package com.insurance.portal.java.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.portal.java.entity.Policy;
import com.insurance.portal.java.services.PolicyService;


@RestController
@RequestMapping(headers = "Accept=application/json", produces = "application/json")
public class PolicyController {

	@Autowired
	PolicyService policyService;

	@RequestMapping(/*(listen to get Method)*/method=RequestMethod.GET, value="/policy/{policyId}/{userId}/{premium}")
	public boolean payPremium(@PathVariable String policyId, @PathVariable String userId, @PathVariable String premium) {
		return policyService.payPremium(policyId,userId,premium).getIsPremiumPaid();
	}

	@RequestMapping(method=RequestMethod.GET, value="/policy/search/{email}/{phone}/{policyId}")
	public Policy searchPolicyDetails(@PathVariable String email, @PathVariable String phone, @PathVariable String policyId) {
		System.out.println("**********email:"+email);
		System.out.println("**********phone:"+phone);
		System.out.println("**********policyId:"+policyId);
		//return policyService.getPolicyDetails("2");
		return policyService.searchPolicyDetails(email,phone,policyId);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/policy/{policyId}")
	public Policy getPolicyDetails(@PathVariable String policyId) {
		return policyService.getPolicyDetails(policyId);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/policy/fresh")
	public List<Policy> getFreshPolicyApplications() {
		return policyService.getFreshPolicyApplications();
	}
	
}
