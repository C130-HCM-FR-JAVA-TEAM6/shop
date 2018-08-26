package com.spring.shop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;
	private String roleName;
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
