package dev.sakila.controller;

import java.util.List;

import dev.sakila.dao.jdbcCountryDAO;
import dev.sakila.model.Country;
import dev.sakila.view.jdbcView;

public class CountryController {

	private final jdbcView jdbcview;
	private final jdbcCountryDAO jdbccountryDAO;
	
	public CountryController() {
		jdbcview = new jdbcView();
		jdbccountryDAO = new jdbcCountryDAO();
	}
	
	
	//나라전체 조회
	public void findAll() {
		
		List<Country> countries = jdbccountryDAO.findAll();
		jdbcview.findAll(countries);
		
	}
	
	public void find(String country) {
		
		jdbcview.findById(jdbccountryDAO.findById(country));
		
	}
	
	//나라추가
	public void add(Country country) {
		jdbccountryDAO.add(country);
		jdbcview.add(country);
		
	}
	
	//나라삭제
	public void delete(Country country) {
		jdbccountryDAO.delete(country);
		jdbcview.delete(country);
	}
	
	//나라수정
	public void update(Country country) {
		jdbccountryDAO.update(country);
		jdbcview.update(country);
		
	}
}
