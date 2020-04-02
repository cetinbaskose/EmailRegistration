package com.microfocus.registration.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.microfocus.registration.controller.SubscriberServiceController;
import com.microfocus.registration.entity.Subscriber;
import com.microfocus.registration.service.SubscriberService;

@RunWith(SpringRunner.class)
@WebMvcTest(SubscriberServiceController.class)
public class ControllerTest2 {

	@MockBean
	private SubscriberService subscriberService;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void test() throws Exception {

		List<Subscriber> mockSubscriberList = new ArrayList<>();
		Subscriber subscriber = new Subscriber();
		subscriber.setId(1);
		subscriber.setName("Cetin Baskose");
		subscriber.setEmailAddress("cetinbaskose@somemail.com");

		mockSubscriberList.add(subscriber);

		when(subscriberService.getAllSubscribers()).thenReturn(mockSubscriberList);

		this.mocMvc.perform(get("/api/subscribers")).andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].name").value("Cetin Baskose"))
				.andExpect(jsonPath("$[0].emailAddress").value("cetinbaskose@somemail.com"));

	}

}
