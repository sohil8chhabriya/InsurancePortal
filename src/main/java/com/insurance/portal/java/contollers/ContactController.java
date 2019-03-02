package com.insurance.portal.java.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.portal.java.entity.Contact;
import com.insurance.portal.java.services.ContactService;

@RestController
@RequestMapping(headers = "Accept=application/json", produces = "application/json")
public class ContactController {
	@Autowired
	private ContactService contactService;

	@RequestMapping(method=RequestMethod.POST, value="/contact")
	public boolean saddContactFormDetails(@RequestBody Contact message) {
		System.out.println("*************************Contact message is getting added");
		return contactService.addContactFormDetails(message);
	}
}