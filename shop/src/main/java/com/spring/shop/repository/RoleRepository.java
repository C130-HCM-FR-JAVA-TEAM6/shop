package com.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.shop.model.Role;
import java.lang.String;


public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRoleName(String rolename);
}
