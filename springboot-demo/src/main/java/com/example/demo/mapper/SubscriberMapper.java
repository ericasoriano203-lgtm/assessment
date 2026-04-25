package com.example.demo.mapper;

import com.example.demo.dto.CallForwardNoReplyDto;
import com.example.demo.dto.FeaturesDto;
import com.example.demo.dto.SubscriberDto;
import com.example.demo.entity.CallForwardNoReply;
import com.example.demo.entity.Subscriber;

public class SubscriberMapper {
	
	public static SubscriberDto mapToSubscriberDto(Subscriber subscriber) {
	    CallForwardNoReplyDto callForward = new CallForwardNoReplyDto(
	            subscriber.getCallForwardNoReply().isProvisioned(),
	            subscriber.getCallForwardNoReply().getDestination()
	    );
	    FeaturesDto features = new FeaturesDto(callForward);
		return new SubscriberDto(
				subscriber.getPhoneNumber(),
				subscriber.getUserName(),
				subscriber.getPassword(),
				subscriber.getDomain(),
				subscriber.getStatus(),
				features
				);
	}
	
	public static Subscriber mapToSubscriber(SubscriberDto subscriberDto) {
		
	    Subscriber subscriber = new Subscriber();
	    subscriber.setPhoneNumber(subscriberDto.getPhoneNumber());
	    subscriber.setUserName(subscriberDto.getUserName());
	    subscriber.setPassword(subscriberDto.getPassword());
	    subscriber.setDomain(subscriberDto.getDomain());
	    subscriber.setStatus(subscriberDto.getStatus());
	    
	    CallForwardNoReply callForward = new CallForwardNoReply();
		callForward.setSubscriber(subscriber);
		callForward.setProvisioned(subscriberDto.getFeatures().getCallForwardNoReply().isProvisioned());
	    callForward.setDestination(subscriberDto.getFeatures().getCallForwardNoReply().getDestination());
	    subscriber.setCallForwardNoReply(callForward);

	    return subscriber;
	}

}
