package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SubscriberDto;

public interface SubscriberService {
	
	SubscriberDto createSubscriber(SubscriberDto subscriberDto);
	
	SubscriberDto getSubscriberByPhoneNumber(Long phoneNumber);
	
	List<SubscriberDto> getAllSubscribers();
	
	SubscriberDto updateSubscriber(Long phoneNumber, SubscriberDto updateSubscriber);

	void deleteSubscriber(Long phoneNumber);
}
