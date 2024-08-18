package com.ecommerce.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_response")
@Entity
public class UserResponse {

	private String companyName;
	private String clientID;
	private String clientSecret;
	private String ownerName;
	private String ownerEmail;
	@Id
	private String rollNo;
}
