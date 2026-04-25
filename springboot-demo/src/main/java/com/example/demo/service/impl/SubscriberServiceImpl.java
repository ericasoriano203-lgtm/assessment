package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.SubscriberDto;
import com.example.demo.entity.CallForwardNoReply;
import com.example.demo.entity.Subscriber;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.SubscriberMapper;
import com.example.demo.repository.SubscriberRepository;
import com.example.demo.service.SubscriberService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class SubscriberServiceImpl implements SubscriberService{
	
	private SubscriberRepository subscriberRepository;

	@Override
	public List<SubscriberDto> getAllSubscribers() {
		List<Subscriber> subscribers = subscriberRepository.findAll();
		return subscribers.stream().map((subscriber) -> SubscriberMapper.mapToSubscriberDto(subscriber))
				.collect(Collectors.toList());
	}


	
	@Override
	public SubscriberDto createSubscriber(SubscriberDto subscriberDto) {
		Subscriber subscriber = SubscriberMapper.mapToSubscriber(subscriberDto);
		Subscriber savedSubscriber = subscriberRepository.save(subscriber);
		return SubscriberMapper.mapToSubscriberDto(savedSubscriber);
	}


	@Override
	public SubscriberDto getSubscriberByPhoneNumber(Long phoneNumber) {
		Subscriber subscriber = subscriberRepository.findById(phoneNumber)
		.orElseThrow(() -> new ResourceNotFoundException("Subscriber does not exist with given phoneNumber : " + phoneNumber));
		return SubscriberMapper.mapToSubscriberDto(subscriber);
	}

	@Override
	public SubscriberDto updateSubscriber(Long phoneNumber, SubscriberDto updatedSubscriber) {
		Subscriber subscriber = subscriberRepository.findById(phoneNumber).orElseThrow(
				() -> new ResourceNotFoundException("Subscriber does not exists with given phoneNumber : " + phoneNumber));
		subscriber.setPhoneNumber(updatedSubscriber.getPhoneNumber());
		subscriber.setUserName(updatedSubscriber.getUserName());
		subscriber.setPassword(updatedSubscriber.getPassword());
		subscriber.setDomain(updatedSubscriber.getDomain());
		subscriber.setStatus(updatedSubscriber.getStatus());
		CallForwardNoReply callForward = new CallForwardNoReply();
		callForward.setSubscriber(subscriber);
		callForward.setPhoneNumber(updatedSubscriber.getPhoneNumber());
		callForward.setProvisioned(updatedSubscriber.getFeatures().getCallForwardNoReply().isProvisioned());
		callForward.setDestination(updatedSubscriber.getFeatures().getCallForwardNoReply().getDestination());
		subscriber.setCallForwardNoReply(callForward);
		Subscriber updatedEmployeeObj = subscriberRepository.save(subscriber);
		return SubscriberMapper.mapToSubscriberDto(updatedEmployeeObj);
	}

	@Override
	public void deleteSubscriber(Long phoneNumber) {
		Subscriber subscriber = subscriberRepository.findById(phoneNumber).orElseThrow(
				() -> new ResourceNotFoundException("Subscriber does not exists with given phoneNumber : " + phoneNumber));
		subscriberRepository.deleteById(phoneNumber);
	}

}
