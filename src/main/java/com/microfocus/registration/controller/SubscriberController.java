package com.microfocus.registration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.microfocus.registration.entity.Subscriber;
import com.microfocus.registration.service.SubscriberService;

@Controller
public class SubscriberController {

	@Autowired
	private SubscriberService subscriberService;

	@GetMapping(value = "/")
	public String defaultPage(Model model, Subscriber subscriber) {
		model.addAttribute("subscribers", subscriberService.getAllSubscribers());
		model.addAttribute("msg", "SUCCESS");
		return "index";
	}

	@PostMapping(value = "/")
	public String adddUser(@Valid Subscriber subscriber, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "error";
		}
		try {
			subscriberService.addSubscriber(subscriber);
			model.addAttribute("success", "The mail adress successfully added to list" );
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage() );

		}
		model.addAttribute("subscribers", subscriberService.getAllSubscribers());
		return "index";
	}

}
