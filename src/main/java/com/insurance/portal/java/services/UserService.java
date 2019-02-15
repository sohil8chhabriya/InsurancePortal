package com.insurance.portal.java.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.insurance.portal.java.entity.*;
import com.insurance.portal.java.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getUserList() {
		List<User> user = new ArrayList<User>();
		userRepository.findAll()
		.forEach(user::add);
		return user;
	}
	
	public Optional<User> getUser(Integer id) {
		return userRepository.findById(id);
		//return this.user.stream().filter(u -> u.getId().equals(id)).findFirst().get();
	}

	public void addUser(User user) {
		/*UserBasicDetails userDetails = user.getUserBasicDetails();
		System.out.println("username:"+userDetails.getName());
		System.out.println("Phone:"+userDetails.getPhone());
		System.out.println("Address:"+userDetails.getAddress());
		System.out.println("Dob:"+userDetails.getDob());
		System.out.println("Gender:"+userDetails.getGender());
		System.out.println("Email:"+userDetails.getEmail());*/
		userRepository.save(user);
	}

	public void updateUser(Integer id, User user) {
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