package dev.sakila;

import dev.sakila.controller.CountryController;
import dev.sakila.model.Country;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountryController countrycontroller = new CountryController();
//		countrycontroller.findAll();
//		countrycontroller.find("Angola");
//		Country country = new Country.Builder().country("Angola").build(); //select one
		
		
		//add �۾�
//		Country country = new Country.Builder().countryID(120).country("test").build();
//		countrycontroller.add(country);
		
		//delete �۾�
//		Country country = new Country.Builder().country("test").build();
//		countrycontroller.delete(country);
		
		//update �۾�
		Country country = new Country.Builder().country("test").build();
		countrycontroller.update(country);
	}
	

}
