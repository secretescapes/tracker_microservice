package com.secretescapes.tracker.controllers;

import com.secretescapes.tracker.domains.Event;
import com.secretescapes.tracker.domains.TdEvent;
import com.secretescapes.tracker.repositories.EventRepository;
import com.secretescapes.tracker.repositories.TdEventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ApiController {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	TdEventRepository tdEventRepository;

	@CrossOrigin(origins = {"http://localhost:8080", "https://www.w3schools.com", "https://localhost:8443"})
	@RequestMapping(value = "/ping", method = GET)
	public HashMap ping(@RequestBody(required = false) Map<String, Object> payload) {
		HashMap data = new HashMap();
		data.put("response", "pong");
		data.put("status", "OK");
		return data;
	}

	@CrossOrigin(origins = {"http://localhost:8080", "https://www.w3schools.com", "https://localhost:8443"})
	@RequestMapping(value = "/v2/event", method = POST)
	public Event push(@Valid @RequestBody Event event) {
		System.out.println("...Reicive event for v2......");

		Event save = eventRepository.save(event);
		return save;
	}

	@CrossOrigin(origins = {"http://localhost:8080", "https://www.w3schools.com", "https://localhost:8443"})
	@RequestMapping(value = "/v1/event", method = POST)
	public Event push(@Valid @RequestBody TdEvent event) {
		@Valid Event save = eventRepository.save(event.getEvent());
		return save;
	}

	@GetMapping("/v1/event")
	public List<Event> getAll() {
		return eventRepository.findAll();
	}

	@GetMapping("/v1/event/{type}")
	public List<Event> getEventsByType(@PathVariable(value = "type") String type) {
		System.out.println("...GOT getEventsByType..." + type);

		return eventRepository.findByType(type);
	}

	@GetMapping("/v1/event/query")
	public List<Event> queryEvents(@RequestParam String type, @RequestParam String dateAsString) {
		System.out.println("...GOT getEventsByType..." + type);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateFormat.parse(dateAsString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return eventRepository.findByTypeAndDateGreaterThan(type, date);
	}
}
