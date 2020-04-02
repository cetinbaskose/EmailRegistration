package com.microfocus.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microfocus.registration.entity.Subscriber;
import com.microfocus.registration.repository.SubscriberRepository;

@Service
public class SubscriberService {

	@Autowired
	private SubscriberRepository subscriberRepository;

	public List<Subscriber> getAllSubscribers() {
		return subscriberRepository.findAll();
	}

	public void addSubscriber(Subscriber subscriber) throws Exception {
		if (!subscriberRepository.findByEmailAddress(subscriber.getEmailAddress()).isPresent()) {
			subscriberRepository.save(subscriber);
			
		} else {
			throw new Exception( "The Email adress is already in the list.");
		}
	}
}
