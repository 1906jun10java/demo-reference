package com.revature.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Flashcard;

@Component
public class FlashcardClient {

	// using this to make HTTP requests and process the responses
	private RestTemplate restTemplate;
	private String resourceUrl = "http://localhost:8082/flashcard";

	@Autowired
	public void setRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	// call our RESTful web service and retrieve all flashcards
	public List<Flashcard> getFlashcards() {
		ResponseEntity<List<Flashcard>> response = this.restTemplate.exchange(this.resourceUrl + "/all", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Flashcard>>() {
				});
		return response.getBody();
	}

}
