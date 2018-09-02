package com.spring.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.model.Role;
import com.spring.shop.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public Role findByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}
}
