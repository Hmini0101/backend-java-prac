package dev.sakila.model;

import java.time.LocalDate;

import dev.sakila.controller.CityController;


public class City {

		private int city_id;
		private String city;
		private int country_id;
		private LocalDate last_update;
		
		public City(int city_id, String city, int country_id, LocalDate last_update) {
			this.city_id = city_id;
			this.city = city;
			this.country_id = country_id;
			this.last_update = last_update;
		}
		
		public City(Builder builder) {
			this.city_id = builder.city_id;
			this.city = builder.city;
			this.country_id = builder.country_id;
			this.last_update = builder.last_update;
		}

		public static class Builder {
			private int city_id;
			private String city;
			private int country_id;
			private LocalDate last_update;

			public Builder cityID(int cityID) {
				this.city_id = cityID;
				return this;
			}

			public Builder city(String city) {
				this.city = city;
				return this;
			}

			public Builder countryID(int countryID) {
				this.country_id = countryID;
				return this;
			}

			public Builder lastUpdate(LocalDate lastUpdate) {
				this.last_update = lastUpdate;
				return this;
			}
			
			public City build() {
				return new City(this);
			}

		}
}
