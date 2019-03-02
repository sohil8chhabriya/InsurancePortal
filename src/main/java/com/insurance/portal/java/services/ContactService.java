package com.insurance.portal.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.portal.java.entity.Contact;
import com.insurance.portal.java.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	public boolean addContactFormDetails(Contact message) {
		Long contactId = contactRepository.save(message).getContactId();
		return (contactId != null);
	}
}
