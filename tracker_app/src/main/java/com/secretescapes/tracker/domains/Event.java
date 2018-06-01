package com.secretescapes.tracker.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.HashMap;

@JsonIgnoreProperties(value = {"c", "date"}, allowGetters = true)
public class Event {

	@Field("t")
	@JsonProperty("t")
	private String type;

	@Field("d")
	@JsonProperty("d")
	private HashMap data;

	@Field("u")
	@JsonProperty("u")
	private User user;

	@JsonProperty("au")
	private Au au;

	@Field("a")
	@JsonProperty("a")
	private Affiliate affiliate;

	@JsonProperty("tr")
	private Au tr;

	@Field("c")
	@JsonProperty("c")
	private Date date = new Date();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Au getTr() {
		return tr;
	}

	public void setTr(Au tr) {
		this.tr = tr;
	}

	public Affiliate getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(Affiliate affiliate) {
		this.affiliate = affiliate;
	}

	public Au getAu() {
		return au;
	}

	public void setAu(Au au) {
		this.au = au;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public HashMap getData() {
		return data;
	}

	public void setData(HashMap data) {
		this.data = data;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	static private class User {
		Long id;
		String e;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getE() {
			return e;
		}

		public void setE(String e) {
			this.e = e;
		}
	}

	static public class Affiliate {
		public String getUrlString() {
			return urlString;
		}

		public void setUrlString(String urlString) {
			this.urlString = urlString;
		}

		String urlString;
	}

	static private class Au {
		String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
