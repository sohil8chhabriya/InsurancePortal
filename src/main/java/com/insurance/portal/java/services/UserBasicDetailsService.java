package com.insurance.portal.java.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.portal.java.entity.*;
import com.insurance.portal.java.repository.UserBasicDetailsRepository;

@Service
public class UserBasicDetailsService {

	@Autowired
	private UserBasicDetailsRepository userRepository;

	public List<UserBasicDetails> getUserList() {
		List<UserBasicDetails> user = new ArrayList<UserBasicDetails>();
		userRepository.findAll()
		.forEach(user::add);
		return user;
	}
	
	public Optional<UserBasicDetails> getUser(Integer id) {
		return userRepository.findById(id);
		//return this.user.stream().filter(u -> u.getId().equals(id)).findFirst().get();
	}

	public void addUser(UserBasicDetails user) {
		System.out.println("username:"+user.getName());
		System.out.println("Phone:"+user.getPhone());
		System.out.println("Address:"+user.getAddress());
		System.out.println("Dob:"+user.getDob());
		System.out.println("Gender:"+user.getGender());
		System.out.println("Email:"+user.getEmail());
		userRepository.save(user);
	}

	public void updateUser(Integer id, UserBasicDetails user) {
		userRepository.save(user);
		//		for(int i = 0; i < this.user.size(); i++) {
		//			User u = this.user.get(i);
		//			if (u.getId().equals(id)) {
		//				this.user.set(i, user);
		//				return;
		//			}
		//		}
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
		//this.user.removeIf(u -> u.getId().equals(id));
	}

}
