package com.insurance.portal.java.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4360637563791732252L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long contactId;
	private String name;
	private String email;
	private String phone;
	private String message;
	
}
