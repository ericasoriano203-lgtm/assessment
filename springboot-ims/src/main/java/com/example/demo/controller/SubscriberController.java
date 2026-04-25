package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SubscriberDto;
import com.example.demo.service.SubscriberService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/ims/subscriber")
public class SubscriberController {
	
	private SubscriberService subscriberService;
	
	// Get All Subscribers
	@GetMapping
	public ResponseEntity<List<SubscriberDto>> getAllEmployees(){
			List<SubscriberDto> employees = subscriberService.getAllSubscribers();
			return ResponseEntity.ok(employees);
	}
	
	// Add Subscriber
	@PostMapping
	public ResponseEntity<SubscriberDto> createSubscriber(@RequestBody SubscriberDto subscriberDto){
		SubscriberDto savedSubscriber = subscriberService.createSubscriber(subscriberDto);
		return new ResponseEntity<>(savedSubscriber, HttpStatus.CREATED);
	}
	
	// Get Subscriber
	@GetMapping("{phoneNumber}")
	public ResponseEntity<SubscriberDto> getSubscriberByPhoneNumber(@PathVariable("phoneNumber")Long phoneNumber){
		SubscriberDto subscriberDto = subscriberService.getSubscriberByPhoneNumber(phoneNumber);
		return ResponseEntity.ok(subscriberDto);
	}
	
	
	// Update Subscriber
	@PutMapping("{phoneNumber}")
	public ResponseEntity<SubscriberDto> updateSubscriber(@PathVariable("phoneNumber") Long phoneNumber, @RequestBody SubscriberDto updatedSubscriber){
		SubscriberDto subscriberDto = subscriberService.updateSubscriber(phoneNumber, updatedSubscriber);
		return ResponseEntity.ok(subscriberDto);
	}
	
	// Delete Subscriber
	@DeleteMapping("{phoneNumber}")
	public ResponseEntity<String> deleteSubscriberByPhone(@PathVariable("phoneNumber")Long phoneNumber){
		subscriberService.deleteSubscriber(phoneNumber);
		return ResponseEntity.ok("Subscriber Deleted Successfully");
	}
	
}
