package com.insurance.portal.java.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.portal.java.SubmitResponse;
import com.insurance.portal.java.entity.*;
import com.insurance.portal.java.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PolicyService policyService;

	public List<User> getUserList() {
		List<User> user = new ArrayList<User>();
		userRepository.findAll()
		.forEach(user::add);
		return user;
	}
	
	public Optional<User> getUser(Integer id) {
		return userRepository.findById(id.longValue());
		//return this.user.stream().filter(u -> u.getId().equals(id)).findFirst().get();
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public void updateUser(Integer id, User user) {
		userRepository.save(user);
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id.longValue());
		//this.user.removeIf(u -> u.getId().equals(id));
	}
	
	public void deleteUser() {
		userRepository.deleteAll();
	}

	public Float calculatePolicyPremium(Integer income, Integer sumAssured, Integer duration) {
		Float totalSumAssured =  0f;
		totalSumAssured += 1000; //baseCharges 
		if(income < 10000) {
			totalSumAssured = totalSumAssured + (float)(income*0.1); 
		} else if(income > 10000) {
			totalSumAssured = totalSumAssured + (float)(income*0.2);
		}
		
		if (duration>0 && duration<10) {
			totalSumAssured = totalSumAssured + (float)(income*0.2);
		} else if (duration>10 && duration<20) {
			totalSumAssured = totalSumAssured + (float)(income*0.22);
		} else if (duration>30 && duration<40) {
			totalSumAssured = totalSumAssured + (float)(income*0.24);
		} else {
			totalSumAssured = totalSumAssured + (float)(income*0.25);
		}
		
		totalSumAssured = totalSumAssured + (float)(sumAssured*0.25);

		return totalSumAssured;
		
	}

	public SubmitResponse createUserWithDefaultPolicyDetails(User user) {
		Float premium = calculatePolicyPremium(user.getIncome(),user.getSumAssured(),user.getDuration());
		user = addUser(user);
		Policy newPolicy = new Policy();
		newPolicy.setPremiumAmount(premium);
		newPolicy.setUser(user);
		newPolicy = policyService.addPolicy(newPolicy);
		return new SubmitResponse(user.getUserId(), newPolicy.getPolicyId(), premium);
		
	}

	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}
	
	public User getUserByPhone(String phone) {
		return userRepository.getUserByPhone(Long.parseLong(phone));
	}

/*	public List<Policy> getAllPoliciesOfUser(String id) {
		return policyService.getAllPolicyByUserId(Long.parseLong(id));
	}*/
}
