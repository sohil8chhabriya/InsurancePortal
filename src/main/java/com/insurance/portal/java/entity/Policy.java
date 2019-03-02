package com.insurance.portal.java.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Policy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7621170851181352488L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer policyId;

	private Float premiumAmount;

	private Boolean isPremiumPaid;

	private String policyStartDate;
	private String policyEndDate;

	private Boolean isPolicyLappsed;
	private Boolean isPolicyDisabled;

	private String dateOfPurchase;

	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@OneToMany(mappedBy="policy")
	@Getter(AccessLevel.NONE)
	private Set<Claim> claim;

}
