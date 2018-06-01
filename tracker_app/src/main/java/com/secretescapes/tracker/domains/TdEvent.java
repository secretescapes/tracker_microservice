package com.secretescapes.tracker.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

public class TdEvent {

	@Field("td")
	@JsonProperty("td")
	Event event;

	@Field("affiliate")
	@JsonProperty("affiliate")
	String affiliate;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(String affiliate) {
		this.affiliate = affiliate;
	}
}
