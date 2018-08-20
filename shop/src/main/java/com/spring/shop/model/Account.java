package com.spring.shop.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="accountId",columnDefinition="accountId")
//	@Column(name="account_id")
	private long accountId;
//	@Column(name="userName",columnDefinition="userName")
//	@Column(name="user_name")
	private String userName;
//	@Column(name="password",columnDefinition="password")
	@Column(name="password")
	private String password;
//	@Column(name="birthday",columnDefinition="birthday")
	private Date birthday;
//	@Column(name="gender",columnDefinition="gender")
	private boolean gender;
//	@Column(name="name",columnDefinition="name")
	private String name;
//	@Column(name="email",columnDefinition="email")
	private String email;
//	@Column(name="address",columnDefinition="address")
	private String address;
//	@Column(name="phone",columnDefinition="phone")
	private String phone;
//	@Column(name="roleId",columnDefinition="roleId")
	private long roleId;
	
	
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
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
}

