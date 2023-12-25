package com.api.mycarsystem.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName; 
	private String lastName;
	private String email;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date birthday;
	private String login;
	private String password;
	private String phone;
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "carId", targetEntity = Car.class)
//	private List<Car> cars;
	
	public User() {
	}
	
	public User(Long id, String firstName, String lastName, String email, Date birthday, String login, String password,
			String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.login = login;
		this.password = password;
		this.phone = phone;
//		this.cars = cars;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	public List<Car> getCars() {
//		return cars;
//	}
//	public void setCars(List<Car> cars) {
//		this.cars = cars;
//	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " + id + " - Nome: " + firstName;
	}
}
