package com.spring.shop.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.shop.model.Account;
import com.spring.shop.model.Role;
import com.spring.shop.repository.AccountRepository;

public class AccountDetailsService implements 	UserDetailsService{
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUserName(username);
		if(account == null) {
			throw new UsernameNotFoundException("dit me may loi roi");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Role role = account.getRole();
		grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		return new org.springframework.security.core.userdetails.User(
                account.getUserName(), account.getPassword(), grantedAuthorities);
	}
}
