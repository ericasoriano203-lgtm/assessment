package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberDto {

	private Long phoneNumber;
	private Long userName;
	private String password;
	private String domain;
	private String status;
	private FeaturesDto features;

}
