package com.secretescapes.tracker.controllers;

import com.secretescapes.tracker.domains.Event;
import com.secretescapes.tracker.domains.TdEvent;
import com.secretescapes.tracker.repositories.EventRepository;
import com.secretescapes.tracker.repositories.TdEventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ApiController {
//	create a cross origin filter
//	https://www.youtube.com/watch?v=l1hazxgwLC0
	@Autowired
	EventRepository eventRepository;

	@Autowired
	TdEventRepository tdEventRepository;

	@CrossOrigin(origins = {"http://localhost:8080","https://www.w3schools.com","https://localhost:8443"})
	@RequestMapping(value = "/ping", method = GET)
	public HashMap ping(@RequestBody(required = false) Map<String, Object> payload) {
		HashMap data = new HashMap();
		data.put("response", "pong");
		data.put("status", "OK");
		return data;
	}

	@CrossOrigin(origins = {"http://localhost:8080","https://www.w3schools.com","https://localhost:8443"})
	@RequestMapping(value = "/v2/event", method = POST)
	public Event push(@Valid @RequestBody Event event) {
		Event save = eventRepository.save(event);
		return save;
	}

	@CrossOrigin(origins = {"http://localhost:8080","https://www.w3schools.com","https://localhost:8443"})
	@RequestMapping(value = "/v1/event", method = POST)
	public TdEvent push(@Valid @RequestBody TdEvent event) {
		@Valid TdEvent save = tdEventRepository.save(event);
		return save;
	}

}
