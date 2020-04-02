package com.microfocus.registration.demo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.StringContains.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.microfocus.registration.controller.SubscriberServiceController;
import com.microfocus.registration.service.SubscriberService;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(SubscriberServiceController.class)
public class SubscriberControllerTest {

	@MockBean
	private SubscriberService subscriberService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void givenHomePageURI_whenMockMVC_thenReturnsIndexViewName() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print())
				.andExpect(view().name("forward:index.html"));
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/index.html")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome to the Mail Subscription Page")));

	}
	


}
