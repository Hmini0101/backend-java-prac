package dev.sakila.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import dev.sakila.model.Country;
import dev.sakila.util.DBUtil;

public class jdbcCountryDAO {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement prepareStatement;

	public List<Country> findAll() {
		List<Country> countries = new ArrayList<>();
		final String select = "SELECT * FROM Country";

		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(select);
			while (resultSet.next()) {
				int id = resultSet.getInt("country_id");
				String country = resultSet.getString("country");

				Date date = resultSet.getDate("last_update");
				LocalDate dueDate = ((java.sql.Date) date).toLocalDate();

				countries.add(new Country(id, country, dueDate));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return countries;
	}

	public Country findById(String country) {
		Country classCountry = null;
		resultSet = null;
		try {
			connection = DBUtil.getConnection();
			prepareStatement = connection.prepareStatement("select * from country where country = ?");
			prepareStatement.setString(1, country);

			resultSet = prepareStatement.executeQuery();
			resultSet.next();

			System.out.println(country);
			int id = resultSet.getInt("country_id");
			String getcountry = resultSet.getString("country");
			Date dueDate = resultSet.getDate("last_update");
			classCountry = new Country(id, getcountry, dueDate.toLocalDate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classCountry;
	}

	public void add(Country country) { // 추가
		connection = DBUtil.getConnection();
		try {
			prepareStatement = connection
					.prepareStatement("insert into country(country_id, country,last_update) values(?,?,?)");
			prepareStatement.setInt(1, country.getId());
			prepareStatement.setString(2, country.getCountry());
			prepareStatement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
			prepareStatement.executeUpdate();
			System.out.println(country.getCountry() + " 인서트완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Country country) { // 삭제
		connection = DBUtil.getConnection();
		try {
			prepareStatement = connection.prepareStatement("delete from country where country =?");
			prepareStatement.setString(1, country.getCountry());
			prepareStatement.executeUpdate();
			System.out.println(country.getCountry() + " 딜리트완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(Country country) { // 업데이트!!!!!!!!!!!!!!!!!!!!!?????
		connection = DBUtil.getConnection();
		try {
			prepareStatement = connection.prepareStatement("update country set country = ? where country = ?");
			prepareStatement.setString(1, country.getCountry());// 업데이트 대상 값
			prepareStatement.setString(2, country.getCountry()); // 업데이트 값
			prepareStatement.executeUpdate();
			System.out.println(country.getCountry() + " 업데이트");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}