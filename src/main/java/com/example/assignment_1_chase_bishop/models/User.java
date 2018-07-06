package com.example.assignment_1_chase_bishop.models;
import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String role;
	private String dateOfBirth;
	

	public void setUser(User newUser) {
		this.username = newUser.username != null ? newUser.username : this.username;
		this.password = newUser.password != null ? newUser.password : this.password;
		this.firstName = newUser.firstName != null ? newUser.firstName : this.firstName;
		this.lastName = newUser.lastName != null ? newUser.lastName : this.lastName;
		this.phone = newUser.phone != null ? newUser.phone : this.phone;
		this.email = newUser.email != null ? newUser.email : this.email;
		this.role = newUser.role != null ? newUser.role : this.role;
		this.dateOfBirth = newUser.dateOfBirth != null ? newUser.dateOfBirth : this.dateOfBirth;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
