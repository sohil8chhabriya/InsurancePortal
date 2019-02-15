package com.insurance.portal.java.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.portal.java.services.UserBasicDetailsService;
import com.insurance.portal.java.entity.*;
@RestController
@RequestMapping(headers = "Accept=application/json", produces = "application/json")
public class UserBasicDetailsRestController {

	@Autowired
	private UserBasicDetailsService userService;

	@RequestMapping(method=RequestMethod.GET, value="/users")
	public List<UserBasicDetails> getUsers() {
		System.out.println("*************************User is getting fetched");
		return userService.getUserList();
	}

	@RequestMapping(method=RequestMethod.GET, value="/users/{id}")
	public Optional<UserBasicDetails> getUser(@PathVariable String id) {
		return userService.getUser(Integer.parseInt(id));
	}

	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody UserBasicDetails user) {
		System.out.println("*************************User is getting added");
		userService.addUser(user);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateUser(@RequestBody UserBasicDetails user, @PathVariable String id) {
		userService.updateUser(Integer.parseInt(id), user);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(Integer.parseInt(id));
	}

}
