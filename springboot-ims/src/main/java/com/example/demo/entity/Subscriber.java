package com.example.demo.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscribers")
public class Subscriber {


	
	@Id
	@Column(name = "phone_number", nullable = false, unique = true)
	private Long phoneNumber;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private Long userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "domain")
	private String domain;
	
	@Column(name = "status")
	private String status;
	
    @OneToOne(mappedBy = "subscriber", cascade = CascadeType.ALL, orphanRemoval = true)
    private CallForwardNoReply callForwardNoReply;


}
