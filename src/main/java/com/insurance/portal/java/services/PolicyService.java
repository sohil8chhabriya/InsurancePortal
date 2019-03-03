package com.insurance.portal.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.portal.java.entity.Policy;
import com.insurance.portal.java.entity.User;
import com.insurance.portal.java.repository.PolicyRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PolicyService {
	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private UserService userService;

	public Policy addPolicy(Policy policy) {
		return policyRepository.save(policy);
	}

	public Policy payPremium(String policyId, String userId, String premium) {
		System.out.println("policy id in int**********************************" + policyId);
		Policy fetchedPolicy = getPolicyDetails(policyId);
		fetchedPolicy.setPremiumAmount(Float.parseFloat(premium));
		fetchedPolicy.setIsPremiumPaid(Boolean.TRUE);
		fetchedPolicy.setPolicyStartDate(new Date().toString());
		fetchedPolicy.setIsPolicyLappsed(Boolean.FALSE);
		System.out.println("fetchedPolicyispremiumpaid**********************************" + fetchedPolicy.getIsPremiumPaid());

		return addPolicy(fetchedPolicy);
	}

/*	public List<Policy> getAllPolicyByUserId(Long i) {
		return policyRepository.findByUserId(i);
	}*/

	public Policy getPolicyDetails(String policyId) {
		return policyRepository.getOne(Integer.parseInt(policyId));
	}
	
	public List<Policy> getFreshPolicyApplications() {
		return policyRepository.findAll();
	}

	public Policy searchPolicyDetails(String email, String phone, String policyId) {
		if(policyId!=null) {
			return getPolicyDetails(policyId);
		} else {
			User u = new User();
			if (email!=null) {
				u = userService.getUserByEmail(email);
			} else if (phone!=null) {
				u = userService.getUserByPhone(phone);
			}
			return policyRepository.findByUser(u);
		}
	}
	
}
