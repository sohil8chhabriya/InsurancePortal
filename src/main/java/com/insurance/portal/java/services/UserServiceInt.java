package com.insurance.portal.java.services;

import com.insurance.portal.java.entity.User;

public interface UserServiceInt {

	void save(User user);

	User findByUsername(String username);

}
