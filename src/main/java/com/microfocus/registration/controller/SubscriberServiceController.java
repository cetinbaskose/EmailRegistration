package com.microfocus.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microfocus.registration.service.SubscriberService;
import com.microfocus.registration.entity.*;

@RestController
@RequestMapping(value = "/api")
public class SubscriberServiceController {

	@Autowired
	private SubscriberService subscriberService;

	@GetMapping(value = "/subscribers")
	public List<Subscriber> getAllSubscribers() {
		return this.subscriberService.getAllSubscribers();
	}

}
