package dev.sakila.model;

import java.time.LocalDate;

public class Country {
	private int country_id;
	private String country;
	private LocalDate last_update;

	public Country(int country_id, String country, LocalDate last_update) {
		super();
		this.country_id = country_id;
		this.country = country;
		this.last_update = last_update;
	}

	public Country(Builder builder) {
		this.country_id = builder.country_id;
		this.country = builder.country;

	}
	
	public int getId() {
		return country_id;
	}
	public String getCountry() {
		return country;
	}
	public LocalDate getLastUpdate() {
		return last_update;
	}
	

	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + ", last_update=" + last_update + "]";
	}


	public static class Builder {
		private int country_id;
		private String country;
		private LocalDate last_update;

		public Builder countryID(int countryID) {
			this.country_id = countryID;
			return this;
		}

		public Builder country(String country) {
			this.country = country;
			return this;
		}

		public Builder lastUpdate(LocalDate lastUpdate) {
			this.last_update = lastUpdate;
			return this;
		}
		
		public Country build() {
			return new Country(this);
		}

	}
}
