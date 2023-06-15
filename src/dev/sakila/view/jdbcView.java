package dev.sakila.view;

import java.util.List;

import dev.sakila.model.Country;

public class jdbcView {

	public void findAll(List<Country> countries) {
		for (Country country : countries) {
			System.out.println(country.getId() + country.getCountry() + country.getLastUpdate());
		}

	}

	public void findById(Country country) {
		System.out.println(country.getId() + " " + country.getCountry() + " " + country.getLastUpdate());
	}

	public void add(Country country) {
		System.out.println("추가완료"+ country.getId() + " " +country.getCountry());
	}

	public void delete(Country country) {
		System.out.println("삭제완료");
	}
	public void update(Country country) {
		System.out.println("업뎃완료");
	}
}
