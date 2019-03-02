package com.insurance.portal.java.contollers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.insurance.portal.java.services.UserService;
import com.insurance.portal.java.SubmitResponse;
import com.insurance.portal.java.entity.*;
@RestController
@RequestMapping(headers = "Accept=application/json", produces = "application/json")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping( value = "/", method = RequestMethod.GET )
	public Set<String> getEndPointsInView()
	{
		Set<String> patternSet = new HashSet<String>();
		for(RequestMappingInfo info: requestMappingHandlerMapping.getHandlerMethods().keySet()) {
			Iterator<String> it = info.getPatternsCondition().getPatterns().iterator();
			while(it.hasNext()) {
				patternSet.add("http://localhost:8080"+it.next());				
			}
	    }
		return patternSet;
	}

	@RequestMapping(method=RequestMethod.GET, value="/users")
	public List<User> getUsers() {
		System.out.println("*************************User is getting fetched");
		return userService.getUserList();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/user/{email}")
	public User getUserByEmail(@PathVariable String email) {
		System.out.println("*************************User is getting fetched using email"+email);
		return userService.getUserByEmail(email);
	}

	@RequestMapping(method=RequestMethod.GET, value="/user/{phone}")
	public User getUserByPhone(@PathVariable String phone) {
		System.out.println("*************************User is getting fetched using phone"+phone);
		return userService.getUserByPhone(phone);
	}
	@RequestMapping(method=RequestMethod.GET, value="/users/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userService.getUser(Integer.parseInt(id));
	}

	@RequestMapping(method=RequestMethod.POST, value="/users")
	public SubmitResponse addUser(@RequestBody User user) {
		System.out.println("*************************User is getting added");
		return userService.createUserWithDefaultPolicyDetails(user);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		userService.updateUser(Integer.parseInt(id), user);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(Integer.parseInt(id));
	}
}
