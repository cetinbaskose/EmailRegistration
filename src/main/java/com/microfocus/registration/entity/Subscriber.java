package com.microfocus.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="SUBSCRIBER")
public class Subscriber {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SUBSCRIBER_ID")
    private long id;
	
	@Column(name="NAME", nullable=false)
    private String name;
    
    @Column(name="EMAIL_ADDRESS",unique=true, nullable=false)
    private String emailAddress;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
    
	
}
