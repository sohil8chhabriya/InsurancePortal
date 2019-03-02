package com.insurance.portal.java.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
@JsonIgnoreProperties
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3682802826483793846L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;

	private String name;
	@Column(unique = true)
	private Long phone;
	@Column(unique = true)
	private String email;
	private String address;
	private String dob;
	private String gender;
	private String occupation;
	@Column(unique = true)
	private String panNo;

	private Integer income;
	private Integer sumAssured;
	private Integer duration;
	
	@OneToMany(mappedBy="user")
	@Getter(AccessLevel.NONE)
	private Set<Policy> policy;
}
