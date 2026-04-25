package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
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
@Table(name = "callforward")
public class CallForwardNoReply {
	
	
    @Id
    @Column(name = "phone_number")
    private Long phoneNumber;

	
	@Column(name = "provisioned", nullable = false, unique = true)
	private boolean provisioned;
	
	@Column(name = "destination", nullable = false, unique = true)
	private String destination;
	
    @OneToOne
    @MapsId
    @JoinColumn(name = "phone_number")
    private Subscriber subscriber;

}
