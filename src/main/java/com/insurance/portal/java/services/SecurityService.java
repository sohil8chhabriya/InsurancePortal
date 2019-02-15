package com.insurance.portal.java.services;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);

}
