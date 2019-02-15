package com.insurance.portal.java.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Data
public class UserBasicDetails {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn
    @MapsId	
	private User user;

	private String name;
	private String phone;
	private String email;
	private String address;
	private String dob;
	private String gender;
	private String occupation;
	private String panNo;
}
