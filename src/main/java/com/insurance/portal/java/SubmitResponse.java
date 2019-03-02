package com.insurance.portal.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitResponse {
	private Long userId;
	private Integer policyId;
	private Float premium;
}
