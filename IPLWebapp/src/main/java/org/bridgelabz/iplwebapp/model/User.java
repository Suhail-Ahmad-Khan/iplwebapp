package org.bridgelabz.iplwebapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@NotEmpty
	@Column(name = "FIRSTNAME")
	private String firstName;

	@NotEmpty
	@Column(name = "LASTNAME")
	private String lastName;

	@NotEmpty
	@Email
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@NotEmpty
	@Size(min = 4, max = 20)
	@Column(name = "USERNAME")
	private String userName;

	@NotEmpty
	@Size(min = 4, max = 20)
	@Column(name = "PASSWORD")
	private String password;

	@NotEmpty
	@Column(name = "COUNTRY")
	private String country;

	@NotEmpty
	@Column(name = "CITY")
	private String city;

	@NotEmpty
	@Column(name = "MOBILE_NO")
	private Long mobileNo;

	@NotNull
	@Past
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
