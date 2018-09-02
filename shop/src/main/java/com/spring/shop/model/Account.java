package com.spring.shop.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;

	private String userName;

	@Column(name = "password")
	private String password;

	private Date birthday;

	private boolean gender;

	private String name;

	private String email;

	private String address;
	
	private String phone;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Account(String userName, String password, Date birthday, boolean gender, String name, String email,
			String address, String phone, Role role) {
		super();
		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.role = role;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return accountId+" - "+name+" - "+userName+" - "+password;
	}
	



}
