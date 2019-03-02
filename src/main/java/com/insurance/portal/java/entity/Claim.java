package com.insurance.portal.java.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Claim implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4932822768165010369L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long claimId;
	private Integer claimAmount;
	private Integer claimAmountDisburse;
	private String dateOfClaim;
	private String dateOfFullClaimDisburse;
	//TODO: This field should be accepting documents files(.pdf, .docx, .jpeg etc)
	private String claimDocumentsCopies;

	@ManyToOne
	@JoinColumn(name="policy_id", nullable=false)
	private Policy policy;
	
}
